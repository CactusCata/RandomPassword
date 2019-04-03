package rdmpswrd.main;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.swing.JOptionPane;

final class Main {

	public static void main(final String[] args) {

		int i = 0;
		try {
			i = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Veuillez séléctionner le nombre de caractères voulue !",
							"RandomPassword", JOptionPane.QUESTION_MESSAGE));
		} catch (final NumberFormatException e) {
			Main.sendMessage("Vous n'avez pas séléctionné un nombre correct !");
			return;
		}

		final StringBuilder build = new StringBuilder();

		while (i > 0) {
			build.append(Character.toChars((int) (33 + (Math.random() * (126 - 33))))[0]);
			i--;
		}

		Main.sendMessage(build.toString());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(build.toString()), null);

	}

	private static void sendMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "RandomPassword", JOptionPane.INFORMATION_MESSAGE);
	}

}
