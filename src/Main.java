import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = System.getProperty("user.dir");
        File textFile = new File(path + "/src/data.txt");

        Reader reader = new Reader();

        ArrayList<String> linesFromFile = reader.readFile(textFile);

        Hashtable<String, String> validGrammar = new Hashtable<String, String>();

        validGrammar.put("{", "}");
        validGrammar.put("(", ")");
        validGrammar.put("[", "]");

        for (String wordToValidate : linesFromFile) {
            Stack lettersToValidate = new Stack();
            Stack complementsFromLetters = new Stack();
            Stack newString = new Stack();

            Boolean isValidWord = true;

            for (char letter : wordToValidate.toCharArray()) {
                try {
                    lettersToValidate.push(letter);

                    if (validGrammar.containsKey(Character.toString(letter)) == true) {
                        newString.push(letter);

                        String currentComplementFromLetter = validGrammar.get(Character.toString(letter));
                        complementsFromLetters.push(currentComplementFromLetter);
                    } else
                        newString.push(complementsFromLetters.pop());

                } catch (Exception e) {
                    isValidWord = false;
                }
            }

            if(isValidWord) {
                String wordValidated = "";
                for (int i = 0; i < newString.size(); i++) {
                    wordValidated += newString.elementAt(i);
                }

                if(!wordValidated.equals(wordToValidate))
                    isValidWord = false;

            }

            System.out.println(wordToValidate + " - " + (isValidWord == true ? "OK" : "Inválido"));
        }
    }
}
