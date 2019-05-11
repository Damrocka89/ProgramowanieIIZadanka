import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        //Stwórz listę imion, i dodaj do niej 5 elementów (Marek, Aleksandra, Marta, Jakub, Bartosz).
        //Wyświetl całą listę.
        //Wyświetl rozmiar listy.
        //Dodaj imię Paulina do listy za pomocą odpowiedniej metody.
        //Wyświetl trzeci element.
        //Wyświetl pierwsze imię z listy od ostatniego do pierwszego znaku. „marek” -> „keram”
        //Wyświetl na którym miejscu w liście jest Jakub.
        //Wyświetl informacje o tym czy lista zawiera imię Sylwia.
        //Wyświetl informacje o tym czy lista zawiera imię Marta.
        //Wyświetl pierwsze 2 elementy.

        List<String> listOfNames = createListWithGivenNamesAndShowTheResult("Marek", "Aleksandra", "Marta", "Jakub", "Bartosz");
        listOfNames.add("Paulina");
        System.out.println(listOfNames.get(2));
        reverseNameFromList(listOfNames, 0);
        System.out.println(listOfNames.indexOf("Jakub") + 1);
        System.out.println(listOfNames.contains("Sylwia"));
        System.out.println(listOfNames.contains("Marta"));
        showSpecifiedNumberOfElements(listOfNames, 2);

        //12.Zamień w liście imię Marek na Sebastian.
        //Wyświetl ostatnie 2 elementy.
        //Połącz wszystkie imiona z listy w jednego stringa i wyświetl.

        listOfNames.set(listOfNames.indexOf("Marek"), "Sebastian");
        //  System.out.println(listOfNames.get(listOfNames.size() - 1) + " " + listOfNames.get(listOfNames.size() - 2));
        listOfNames.stream()
                .skip(listOfNames.size() - 2)
                .forEach(System.out::println);

        System.out.println(String.join(" ", listOfNames));

        //Połącz wszystkie imiona z listy, które zawierają literę „s” w jednego stringa i wyświetl.

        System.out.println(listOfNames.stream()
                .filter(name -> name.contains("s"))
                .collect(Collectors.joining(" ")));

        //Wyświetl drugą i trzecią literę każdego imienia z listy.

        for (String name : listOfNames) {
            System.out.println(name.charAt(2) + " " + name.charAt(3));
        }

//        listOfNames.stream()
//                .forEach(name -> Arrays.stream(name.split(""))
//                        .skip(1)
//                        .limit(2)
//                        .forEach(letter -> System.out.print(letter + " ")));
//        System.out.println("");

        //Wyświetl listę w odwrotnej kolejności.

        Collections.reverse(listOfNames);
        System.out.println(listOfNames);
        Collections.reverse(listOfNames);

//        for (int i = listOfNames.size()-1; i >=0; i--) {
//            System.out.print(listOfNames.get(i) + " ");
//        }
//        System.out.println("");

        //Wyświetl imiona z listy, które zaczynają się na „M” lub kończą na „A”.

        listOfNames.stream()
                .filter(name -> name.codePointAt(0) == 'M' || name.codePointAt(0) == 'A')
                .forEach(System.out::println);

        //Wyświetl wszystkie imiona łącznie z ilością znaków, z których się składają.

        listOfNames.forEach(name -> System.out.println(name + " " + name.length()));

        //20.Stwórz nową listę zawierającą 2 imiona (Anna, Maciej) i dodaj tę listę do naszej pierwszej listy.

        List<String> kolejnaListaImion = Arrays.asList("Anna", "Maciej");
        listOfNames.addAll(kolejnaListaImion);

        //Wyświetl informacje o tym czy lista zawiera imiona Aleksandra, Marta i Jakub.

        checkIfListContainsGivenNames(listOfNames, "Aleksandra", "Marta", "Jakub");

        //Wyświetl wszystkie imiona z listy w formacie „indeks listy: imię” np. 3: Marta.

        listOfNames.forEach(name-> System.out.println(listOfNames.indexOf(name)+": "+name));

        //Usuń z listy pierwszy element i go wyświetl.

        System.out.println(listOfNames.remove(0));

        //Usuń imię „Jakub” z listy.

        listOfNames.remove("Jakub");

        //Posortuj listę alfabetycznie rosnąco. (*)

        listOfNames.sort(Comparator.naturalOrder());

        //Posortuj listę alfabetycznie malejąco. (*)

        listOfNames.sort(Comparator.reverseOrder());

        //Sprawdź czy lista jest pusta i wyświetl tę informację.

        System.out.println(listOfNames.isEmpty());

        //Wyczyść listę i wyświetl jej zawartość.

        listOfNames.clear();
        System.out.println(listOfNames);

        //Ponownie sprawdź czy lista jest pusta.

        System.out.println(listOfNames.isEmpty());

        // 30 .Stwórz Set imion, i dodaj do niego 5 elementów (Marek, Aleksandra, Marta, Jakub, Bartosz).

        Set<String> setOfNames = new HashSet<>(Arrays.asList("Marek", "Aleksandra", "Marta", "Jakub", "Bartosz"));

        

    }

    private static void checkIfListContainsGivenNames(List<String> listOfNames, String... names) {
        for (String name : names) {
            if (listOfNames.contains(name)) {
                System.out.println("List contains name: " + name);
            } else {
                System.out.println("List doesn't contain name: " + name);
            }
        }
    }

    public static void showSpecifiedNumberOfElements(List<String> listaImion, int numberOfElements) {
        listaImion.stream()
                .limit(numberOfElements)
                .forEach(System.out::println);
    }

    public static List<String> createListWithGivenNamesAndShowTheResult(String... names) {
        List<String> listaImion = new ArrayList<>(Arrays.asList(names));
        System.out.println(listaImion);
        System.out.println(listaImion.size());
        return listaImion;
    }

    public static void reverseNameFromList(List<String> listaImion, int index) {
//        StringBuilder sb =new StringBuilder();
//        System.out.println(sb.append(listaImion.get(index)).reverse().toString().toLowerCase());

        String word = listaImion.get(index);
        for (int i = 0; i < word.length(); i++) {
            System.out.print(word.substring(word.length() - i - 1, word.length() - i).toLowerCase());
        }
        System.out.println();

    }
}
