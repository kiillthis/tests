//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.regex.Pattern;
//import java.util.stream.Stream;
//
//public class RegexTest {
//
//    /**
//     * в тестах ты придум. regex чтобы:
//     * - разбить имя фамилию(с одной строке) на отдельно имя и фамилию(разные строки)
//     * - взять из пути к файлу расширение(если оно вообще есть)
//     * - определить это путь к аудио-файлу(wav, mp3) или нет
//     * и тестируешь его
//     * match/find потестить
//     */
////    "[A-Z]{1}[a-z]*[\\S$]"
//
//    final static String FULLNAME_REGEX = "\\s*(([A-Z]{1}[a-z]*)\\s+([A-Z]{1}[a-z]*))\\s*$";
//    final static String PATH_REGEX = "(.*)(\\..+)";
//    final static String AUDIO_CHECK_REGEX = ".*(\\.wav|\\.mp3)";
//
//    public final Pattern fullNamePattern = Pattern.compile(FULLNAME_REGEX);
//    public final Pattern pathPattern = Pattern.compile(PATH_REGEX);
//    public final Pattern audioPattern = Pattern.compile(AUDIO_CHECK_REGEX);
//    // сделать с  methodSource
//    // добавить неcколько кейсов: несколько пробелом спереди, сзади ...
//    // добавить несколько неподходящих кейсов то, что не матчиться. отдельный параметр. кейсов
//    // понятия: capturing group, non-capt. group
//
//    // ----
//    // match/find потестить
//    // переназвать тест
//    // nonMatch in extensionProvider test
//    // fix regex + take value from groups
//    // ?: юзать
//
//    @ParameterizedTest
//    @MethodSource("stringProviderMatch")
//    public void splitNameAndSurname(String argument, String name, String lastName) {
//        var matcher = fullNamePattern.matcher(argument);
//
//
//        Assertions.assertTrue(matcher.matches());
//        Assertions.assertEquals(name, matcher.group(2));
//        Assertions.assertEquals(lastName, matcher.group(3));
//    }
//
//    @ParameterizedTest
//    @MethodSource("stringProviderNonMatch")
//    public void splitNameAndSurnameNonMatch(String argument) {
//        var matcher = fullNamePattern.matcher(argument);
//
//        Assertions.assertFalse(matcher.find());
//    }
//
//    @ParameterizedTest
//    @MethodSource("extensionProvider")
//    public void takeExtensionFromFile(String file, String extension) {
//        var matcher = pathPattern.matcher(file);
//
//        Assertions.assertTrue(matcher.matches());
//
//        String ext = matcher.group(2);
//
//        Assertions.assertEquals(extension, ext);
//    }
//
//    @ParameterizedTest
//    @MethodSource("extensionProviderNonMatch")
//    public void takeExtensionFromFileNonMatch(String file) {
//        var matcher = pathPattern.matcher(file);
//
//        Assertions.assertFalse(matcher.matches());
//    }
//
//    @ParameterizedTest
//    @MethodSource("filesProvider")
//    public void isPathToAudioFile(String file, Boolean isAudio) {
//        var matcher = audioPattern.matcher(file);
//
//        boolean isAudioCheck = matcher.matches();
//
//        Assertions.assertEquals(isAudio, isAudioCheck);
//    }
//
//    public static Stream<Arguments> stringProviderMatch() {
//        return Stream.of(
//                Arguments.arguments("Andrii Kompaniiets", "Andrii", "Kompaniiets"),
//                Arguments.arguments("Ivan   Ivanov", "Ivan", "Ivanov"),
//                Arguments.arguments("  Petr   Petrov", "Petr", "Petrov")
//        );
//    }
//
//    public static Stream<String> stringProviderNonMatch() {
//        return Stream.of("andrii kompaniiets","12van ivanov$","petR");
//    }
//
//    public static Stream<Arguments> extensionProvider() {
//        return Stream.of(
//                Arguments.arguments("text.txt", ".txt"),
//                Arguments.arguments("audio.wav", ".wav"),
//                Arguments.arguments("audio.wav.mp3", ".mp3")
//        );
//    }
//
//    public static Stream<String> extensionProviderNonMatch() {
//        return Stream.of("text", "dgbgb", "sfgfg.", "  %454");
//    }
//
//    public static Stream<Arguments> filesProvider() {
//        return Stream.of(
//                Arguments.arguments("audio.mp3", true),
//                Arguments.arguments("sound.wav", true),
//                Arguments.arguments("text.txt", false),
//                Arguments.arguments("document.doc", false),
//                Arguments.arguments("sound.mp3.txt", false),
//                Arguments.arguments("sound.txt.mp3", true),
//                Arguments.arguments("sfgkjnfg", false),
//                Arguments.arguments("", false),
//                Arguments.arguments("   ", false)
//        );
//    }
//}
