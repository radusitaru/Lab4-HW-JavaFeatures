import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class LogicalSwitch {

    static Predicate<Person> ageUnder30 = person -> person.age() < 30;
    Predicate<Person> ageOver30 = person -> person.age() > 30;

    static Map<Predicate<Person>, Function<Person, String>> processingMap;

    static Function<Person,String> displayName = Person::name;
}
