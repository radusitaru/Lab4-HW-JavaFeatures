import java.util.function.Function;

public record Person(String name, int age, String address)  {


    //Creeaza un obiect Person(String name,int age, String address)
    //Creeaza un obiect LogicalSwitch care simuleaza un switch logic folosind Predicate.
    // Astfel vom avea un Map care are ca si cheie un Predicate<Person> si valoare Function<Person, String>
    //Astfel vom putea procesa o persoana si se vor aplica toate entry-urile care se aplica personaei.
    //Testati aplicatia.

}
