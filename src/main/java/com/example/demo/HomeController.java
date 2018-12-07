package com.example.demo;

import net.bytebuddy.asm.Advice;
import org.apache.maven.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    Movierepository movierepository;

    @RequestMapping ("/")
    public String index(Model model){
    //First lets create an actor
        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae Bullowski");
// Now let’s create a movie
        Movie movie = new Movie ();
        movie.setTitle(“Emoji Movie”);
        movie.setYear(2017);
        movie.setDescription(“About Emojis…”);

// Add the movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

// Add the list of movies to the actor’s movie list
        actor.setMovies(movies);

// Save the actor to the database
        actor.Repository.save(actor);

// Grad all the actors from the database and send them to
// the template
        model.addAttribute(“actors”, actorRepository.findAll());
        return “index”;

    }
}


