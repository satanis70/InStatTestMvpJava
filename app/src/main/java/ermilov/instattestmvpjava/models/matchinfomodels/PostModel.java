package ermilov.instattestmvpjava.models.matchinfomodels;

public class PostModel {

    public  class Params{
        public int _p_sport;
        public int _p_match_id;
    }

    public  class Root{
        public String proc;
        public Params params;
    }
}
