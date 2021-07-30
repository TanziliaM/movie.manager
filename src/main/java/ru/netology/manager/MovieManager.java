package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MovieManager {
  private Movie[] movies = new Movie[0];
  private int defaultMovieLength = 10;


  public MovieManager(int customMovieLength) {
    if (customMovieLength > 0) {
      defaultMovieLength = customMovieLength;
    }
  }

  public void addMovie(Movie movie) {
    int length = movies.length + 1;
    Movie[] tmp = new Movie[length];
    for (int i = 0; i < movies.length; i++) {
      tmp[i] = movies[i];
    }
    System.arraycopy(movies, 0, tmp, 0, movies.length);
    int lastMovie = tmp.length - 1;
    tmp[lastMovie] = movie;
    movies = tmp;
  }


  public Movie[] getLast() {
    int temp;
    if (movies.length <= defaultMovieLength) {
      temp = movies.length;

    } else {
      temp = movies.length;
    }
    Movie[] result = new Movie[temp];
    for (int i = 0; i < temp; i++) {
      int index = movies.length - i - 1;
      result[i] = movies[index];
    }
    return result;
  }
  public void removeById(int id) {
    int length = movies.length - 1;
    Movie[] tmp = new Movie[length];
    int index = 0;
    for (Movie item : movies) {
      if (item.getId() != id) {
        tmp[index] = item;
        index++;
      }
    }
    movies = tmp;
  }
}