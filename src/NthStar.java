import java.util.*;

public class NthStar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int k = Integer.parseInt(inputArray[0]);
        int m = Integer.parseInt(inputArray[1]);
        int n = Integer.parseInt(inputArray[2]);

        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String name = scanner.nextLine();
            String data = scanner.nextLine();
            String[] dataArray = data.split(" ");
            int points = 0;
            for (int j = 0; j < m; j++) {
                points += Integer.parseInt(dataArray[j]);
            }
            Team team = new Team(name, points);
            teams.add(team);
        }
        Collections.sort(teams);

        Map<Integer, List<Team>> rankMap = new HashMap<>();
        int rank = 1;
        Team previousTeam = teams.get(0);
        int sameRank = 1;
        rankMap.computeIfAbsent(rank, r -> new ArrayList<>()).add(previousTeam);
        for (int i = 1; i < teams.size(); i++) {
            Team currentTeam = teams.get(i);
            if (currentTeam.getScore() != previousTeam.getScore()) {
                if (sameRank == 1) {
                    rank++;
                } else {
                    rank += 2;
                }
            } else {
                sameRank++;
            }
            previousTeam = currentTeam;
            rankMap.computeIfAbsent(rank, r -> new ArrayList<>()).add(currentTeam);
        }

//        rankMap.forEach((r, l) -> {
//            System.out.println(r + " " + l.size());
//            for (Team team : l) {
//                System.out.println(team.getName() + " " + team.getScore());
//            }
//        });

        List<Team> nthStar = rankMap.getOrDefault(n, new ArrayList<>());
        if (nthStar.isEmpty()) {
            System.out.println("No team");
        } else {
            for (Team team : nthStar) {
                System.out.println(team.getName());
            }
        }
    }

    public static class Team implements Comparable<Team> {
        private String name;
        private int score;

        public Team(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Team o) {
            return Integer.compare(o.getScore(), this.getScore());
        }
    }
}
