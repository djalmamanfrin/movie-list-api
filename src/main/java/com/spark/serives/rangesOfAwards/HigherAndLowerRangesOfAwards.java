package com.spark.serives.rangesOfAwards;

public class HigherAndLowerRangesOfAwards {
  private List<MovieListDto> movieList;
  private List<Movies> movies;
  private List<Producers> producers;
  private Map<String, Long> result;

  public HigherAndLowerRangesOfAwards() {
      movies = new ArrayList<>();
      producers = new ArrayList<>();
      movieList = reader.getMovies();
  }

  public void execute() {
      movieList.stream().filter(movieList.getWinner())
        .forEach(movie -> movies.add(new Movies(movie)));

      this.movies.forEach(movie ->
        movie.forEach(producer -> producers.add(producer)));

      Map<Double,Long> producersCount = producers.stream()
        .collect(Collectors.groupingBy(Producers::getName,Collectors.counting()));

      result = map.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
  }

  public Map<String, Long> getRangesOfAwards() {
      return result;
  }
}
