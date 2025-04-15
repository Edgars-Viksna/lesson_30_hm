
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        List<Integer> integerList = List.of(2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5);
        List<String> stringList = List.of("aaa", "bbb", "bbb", "ccc", "ccc", "ccc");
        List<String> stringList1 = List.of("bbb", "bbb", "ccc", "ccc", "ccc");

        List<Person> personList = List.of(new Person("Aaaaa"), new Person("Aaaaa"),
                new Person("Bbbbb"), new Person("Ccccc"));
        List<Book> bookList = List.of(new Book("Alladin", 100), new Book("Alladin", 100),
                new Book("Buratino", 200));


        // -------------------------------- implementing Methods --------------------

        print(integerList);
        print(stringList);
        print(personList);
        print(bookList);

        System.out.println("---------- Method count strings -------------");
        System.out.println(count(stringList, "aaa"));
        System.out.println(count(stringList, "ccc"));

        System.out.println("---------- Method count Integers-------------");
        System.out.println(count(integerList, 4));
        System.out.println(count(integerList, 5));

        System.out.println("---------- Method count Persons -------------");
        System.out.println(count(personList, new Person("Aaaaa")));

        System.out.println("---------- Method count Book -------------");
        System.out.println(count(bookList, new Book("Alladin", 100)));

        System.out.println("---------- Method count same position -------------");
        System.out.println(samePosition(stringList, stringList1));


    }

// -------------------------------- Methods --------------------

    public static <T> void print(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    public static <T> int count(List<T> list, T element) {
        int result = 0;
        for (T item : list) {
            if (element.equals(item)) {
                result = result + 1;
            }
        }
        return result;
    }

    public static <T> List<T> samePosition(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i).equals(list2.get(i))) {
                result.add(list1.get(i));
            }
        }
        return result;
    }
}


// -------------------------------- Sub classes ---------------

    class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }
    }

    class Book {
        private String title;
        private int pages;

        public Book(String title, int pages) {
            this.title = title;
            this.pages = pages;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", pages=" + pages +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return pages == book.pages && Objects.equals(title, book.title);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, pages);
        }
    }



