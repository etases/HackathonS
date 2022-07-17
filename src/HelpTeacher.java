import java.util.*;

public class HelpTeacher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<TeacherName> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = input.nextLine();
            names.add(new TeacherName(name));
        }
        Collections.sort(names);
        for (TeacherName name : names) {
            System.out.println(name.getName());
        }
    }

    public static class TeacherName implements Comparable<TeacherName> {
        private String firstName;
        private String lastName;
        private String middleName;

        public TeacherName(String name) {
            String[] names = name.split(" ");
            firstName = names[0];
            if (names.length == 2) {
                lastName = names[1];
                middleName = "";
            } else {
                lastName = names[names.length - 1];
                middleName = String.join(" ", Arrays.copyOfRange(names, 1, names.length - 1));
            }
        }

        @Override
        public int compareTo(TeacherName o) {
            int result = lastName.compareTo(o.lastName);
            if (result == 0) {
                result = firstName.compareTo(o.firstName);
                if (result == 0) {
                    result = middleName.compareTo(o.middleName);
                }
            }
            return result;
        }

        public String getName() {
            if (middleName.isEmpty()) {
                return firstName + " " + lastName;
            } else {
                return firstName + " " + middleName + " " + lastName;
            }
        }
    }
}
