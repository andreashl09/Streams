package de.example.library;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        library.getMembers().add(new Member("Himan", 2024001));
        library.getMembers().add(new Member("Superman", 2024002));
        library.getMembers().add(new Member("Batman", 2024003));
        library.getMembers().add(new Member("Wonder Woman", 2024004));
        library.getMembers().add(new Member("Spider-Man", 2024005));
        library.getMembers().add(new Member("Hulk", 2024006));

        library.getBooks().add(new Book("Die Odyssee", "Homer", Genre.KLASSIKER, -800));
        library.getBooks().add(new Book("Moby Dick", "Herman Melville", Genre.KLASSIKER, 1851));
        library.getBooks().add(new Book("Neuromancer", "William Gibson", Genre.SCIENCE_FICTION, 1984));
        library.getBooks().add(new Book("1984", "George Orwell", Genre.SCIENCE_FICTION, 1949));
        library.getBooks().add(new Book("Der Name der Rose", "Umberto Eco", Genre.KRIMINALROMAN, 1980));
        library.getBooks().add(new Book("Sherlock Holmes: Eine Studie in Scharlachrot", "Arthur Conan Doyle", Genre.KRIMINALROMAN, 1887));
        library.getBooks().add(new Book("Der Herr der Ringe", "J.R.R. Tolkien", Genre.FANTASY, 1954));
        library.getBooks().add(new Book("Der Hobbit", "J.R.R. Tolkien", Genre.FANTASY, 1937));
        library.getBooks().add(new Book("Harry Potter und der Stein der Weisen", "J.K. Rowling", Genre.FANTASY, 1997));
        library.getBooks().add(new Book("Harry Potter und die Kammer des Schreckens", "J.K. Rowling", Genre.FANTASY, 1998));
        library.getBooks().add(new Book("Funktionale Programmierung verstehen", "Jack Widman", Genre.IT, 2023));
        library.getBooks().add(new Book("Einführung in Algorithmen", "Thomas H. Cormen", Genre.IT, 2009));
        library.getBooks().add(new Book("Ich, Robot", "Isaac Asimov", Genre.SCIENCE_FICTION, 1950));
        library.getBooks().add(new Book("Foundation", "Isaac Asimov", Genre.SCIENCE_FICTION, 1951));
        library.getBooks().add(new Book("Carrie", "Stephen King", Genre.SCIENCE_FICTION, 1974));
        library.getBooks().add(new Book("The Shining", "Stephen King", Genre.SCIENCE_FICTION, 1977));
        library.getBooks().add(new Book("Mord im Orient-Express", "Agatha Christie", Genre.KRIMINALROMAN, 1934));
        library.getBooks().add(new Book("Tod auf dem Nil", "Agatha Christie", Genre.KRIMINALROMAN, 1937));
        library.getBooks().add(new Book("Das Silmarillion", "J.R.R. Tolkien", Genre.FANTASY, 1977));
        library.getBooks().add(new Book("Die Kinder Húrin", "J.R.R. Tolkien", Genre.FANTASY, 2007));

        library.borrowBook(2024001, "Der Hobbit");
        library.borrowBook(2024001, "Tod auf dem Nil");
        library.borrowBook(2024001, "Der Hobbit");
        library.borrowBook(2024001, "Der Hobbit");
        library.borrowBook(2024001, "Neuromancer");
        library.borrowBook(2024001, "Der Hobbit");
        library.borrowBook(2024001, "Tod auf dem Nil");
        library.borrowBook(2024001, "Tod auf dem Nil");
        library.borrowBook(2024001, "Neuromancer");
        library.borrowBook(2024001, "The Shining");
        library.borrowBook(2024001, "Die Kinder Húrin");

//        library.borrowedBookBack(2024001, "Der Hobbit");

        System.out.println(dottedLine(50) + " Alle ausgeliehenen Bücher " + dottedLine(50));
        library.ListOfAllBorrowedBooks();
        System.out.println();

        System.out.println(dottedLine(50) + "Alle verfügbaren Authoren:" + dottedLine(50));
        System.out.println(library.listOfAllAuthorsWithoutDuplicates());
        System.out.println();

        System.out.println(dottedLine(42) + " Durchschnittliches Veröffentlichungsjahr " +dottedLine(42));
        System.out.println(library.averageYearOfPublicationOfTheBooks());
        System.out.println();


        Genre genre = Genre.IT;
        System.out.println(dottedLine(50) + " Alle Bücher des Genre: " + genre + " " +dottedLine(50));
        library.allBooksOfSpecificGenre(genre);
        System.out.println();

        System.out.println(dottedLine(50) + " Alle ausgeliehenen Bücher " +dottedLine(50));
        library.borrowedBooksFromMember(2024001);
        System.out.println();

        System.out.println(dottedLine(50) + " Die Top 5 der ausgeliehenen Bücher " + dottedLine(50));
        library.topFiveBorrowedBooks();
        System.out.println();

        System.out.println(dottedLine(50) + " Kategorisierte Bücher " + dottedLine(50));
        library.categoryTheBooks();



    }

    public static String dottedLine(int anzahl) {
        if (anzahl < 0) return "";
        return "*" + dottedLine(anzahl - 1);
    }
}
