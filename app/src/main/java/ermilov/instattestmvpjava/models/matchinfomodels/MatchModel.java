package ermilov.instattestmvpjava.models.matchinfomodels;

public class MatchModel {
    public class Tournament{
        public int id;
        public String name_eng;
        public String name_rus;
    }

    public class Team1{
        public int id;
        public String name_eng;
        public String name_rus;
        public int score;
    }

    public class Team2{
        public int id;
        public String name_eng;
        public String name_rus;
        public int score;
    }

    public class Root{
        public Tournament tournament;
        public String date;
        public Team1 team1;
        public Team2 team2;
        public int stream_status;

        public Tournament getTournament() {
            return tournament;
        }

        public void setTournament(Tournament tournament) {
            this.tournament = tournament;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Team1 getTeam1() {
            return team1;
        }

        public void setTeam1(Team1 team1) {
            this.team1 = team1;
        }

        public Team2 getTeam2() {
            return team2;
        }

        public void setTeam2(Team2 team2) {
            this.team2 = team2;
        }

        public int getStream_status() {
            return stream_status;
        }

        public void setStream_status(int stream_status) {
            this.stream_status = stream_status;
        }
    }
}
