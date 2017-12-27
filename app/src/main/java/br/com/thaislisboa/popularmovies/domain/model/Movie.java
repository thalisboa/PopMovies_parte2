package br.com.thaislisboa.popularmovies.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private long id;
    private boolean video;
    private double voteAverage;
    private String title;
    private String poster;
    private String backdrop;
    private String overview;
    private String date;
    private ArrayList<Trailer> trailers;
    public ArrayList<Review> reviews;

    public Movie() {
    }

    public Movie(long id, boolean video, double voteAverage,
                 String title, String poster, String backdrop, String overview, String date) {
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.poster = poster;
        this.backdrop = backdrop;
        this.overview = overview;
        this.date = date;
        this.trailers = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public boolean isVideo() {
        return video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public static String getGrade() {
        return String.format("%s/10", getVoteAverage());
    }

    public static String getTitle() {
        return title;
    }

    public static String getPoster() {
        return "http://image.tmdb.org/t/p/w780/".concat(poster);
    }

    public String getBackdrop() {
        return "http://image.tmdb.org/t/p/w342/".concat(backdrop);
    }

    public static String getOverview() {
        return overview;
    }

    public String getDate() {
        return date;
    }

    public static String getYear() {
        String[] date = getDate().split("-");
        return date[0];
    }

    public void addTrailer(String name, String keyYouTube) {
        getTrailers().add(new Trailer(name, keyYouTube));
    }


    public String getTrailerYoutube(int position) {
        Trailer t = getTrailers().get(position);


        if (t == null) {
            return "";

        } else {

            return t.getYouTube();
        }

    }

    public ArrayList<Trailer> getTrailers() {
        return trailers;
    }

    public String getTrailerName(int position) {
        Trailer t = getTrailers().get(position);

        if (t == null) {
            return "";
        } else {
            return t.getName();
        }
    }

    public int getTrailersSize() {

        return getTrailers().size();
    }


    @Override
    public String toString() {
        return "Movie{" + "id=" + id +
                ", video=" + video +
                ", voteAverage=" + voteAverage +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", backdrop='" + backdrop + '\'' +
                ", overview='" + overview + '\'' +
                ", date='" + date + '\'' +
                '}';
    }


    public ArrayList<Review> getReviews() {
        return reviews;

    }

    public void addReview(String name, String comment) {
        getReviews().add(new Review(name, comment));
    }

    public String getReviewName(int position) {
        Review r = getReviews().get(position);

        if (r == null) {
            return "";
        } else {
            return r.getName();
        }
    }

    public String getReviewComment(int position) {
        Review r = getReviews().get(position);

        if (r == null) {
            return "";
        } else {
            return r.getComment();
        }
    }


    public int getReviewsSize() {
        return getReviews().size();
    }
}
