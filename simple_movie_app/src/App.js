import React, { useState, useEffect } from "react";
import axios from "axios";
import Movie from "./Movie";
import "./App.css"

function App() {
  const [isLoading, setIsLoading] = useState(true);
  const [movies, setMovies] = useState([{}]);

  // async, await은 axios를 통해 가져오는 data를 기다리는데 시간이 조금 걸린다는 것을 알려주고 기다리게 한다.
  // 이 형식을 사용하지 않을 경우, 이 function을 기다리지 않기 때문이다.
  var getMovies = async() => {
    const {data: {data :{movies}}} 
    = await axios.get("https://yts-proxy.nomadcoders1.now.sh/list_movies.json");
    // = await axios.get("https://ab05cf3e-683f-4d62-90d5-1315f4ce63a6.mock.pstmn.io");
    setMovies(movies);
    setIsLoading(false)
  }

  // ComponentDidMout와 같은 동작
  useEffect(() => {
    // setTimeout(() => {setIsLoading(false)}, 3000)
    getMovies()
  });
  
  return (
    <section className="container">
      {isLoading ? (
      <div className= "loader">
        <span className="loader__text">Loading...</span>
      </div>
      ) : (
      <div className= "movies">
        {movies.map(movie => {
        return <Movie 
        key={movie.id} 
        year={movie.year} 
        title={movie.title} 
        summary={movie.summary} 
        poster={movie.medium_cover_image} 
        genres={movie.genres}/>
        })}
      </div>
      )}
    </section>
  );
}

export default App;
