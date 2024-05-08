# CSC120-FinalProject

## Deliverables:
 - Your final codebase  -) Complete
 - Your revised annotated architecture diagram  -) Complete (See file)
 - Design justification (including a brief discussion of at least one alternative you considered) -) Complete (See file)
 - A map of your game's layout (if applicable) -) Complete (See file)
 - `cheatsheet.md` -) Complete (See file)
 - Completed `rubric.md` -) Complete (See file)
  
## Abby: Additional Reflection Questions

- What was your **overall approach** to tackling this project?

It started with a general idea for the game involving user-navigated biomes with added challenge of quizzing the user on biome facts. We began by creating the biome class and the subclasses for each individual biome, then building the game loop with guava to navigate between biomes, adding in the riddles for each species. We then built the lab to store the inventory, finally adding in graphics for the lab and the biome as the user travels through the game.

- What **new thing(s)** did you learn / figure out in completing this project?

Adding graphics and using guava were both new challenges when completing this project.

- Is there anything that you wish you had **implemented differently**?

I think there possibly could have been fewer classes to work with, however, having separate classes for our different elements made it easier to keep track of work and separate the different aspects of the game.

- If you had **unlimited time**, what additional features would you implement?

I think it would be cool to have more graphics and/or more interactive graphics. With more time, we could have added graphics for the found animals/plants, or even the monsters as they approached.

- What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?

I think the most helpful feedback I received was from Mikayle, whose project inspired the added level in our game beyond the riddles. We needed a more "locked" aspect of the game beyond not being able to get to certain biomes from others, so it was helpful to see their game and add the integer "quiz" portion of the game.

- If you could go back in time and give your past self some **advice** about this project, what hints would you give?

I think I would advise my past self that our ideas for the project can evolve as we work. I think we went in with a solid plan, but did not originally go as planned, so we had to change how the biomes and lab were built.

- If you worked with a team: please comment on how your **team dynamics** influenced your experience working on this project.

I think our team worked well together. We both brought a lot of really good ideas to the project and did well to collaborate and let ourselves be more creative with the concepts. We worked both independently and together, and were able to get things done in a timely manner.



## Maura: Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
    
Initially, we approached this project by thinking about my favorite topics. We like nature, so we wanted to build an educational and environmental game. From there, we designed a map of what our biome world might look like and used Zork as inspiration for a game premise where the user could choose where to go and collect items, such as endangered creatures and mythical monsters, along the way.
	
I discussed this more in the team dynamics sections, but Abby and I split the work and focused on separate branches to tackle this project. We did this by first deciding which classes we needed to include in our project and splitting who did which class. When I wasn’t sure how to implement a feature, I consulted Google core libraries and did online research, often by looking at questions previously answered on Stack Overflow. Reviewing previous CS assignments was also incredibly helpful since it taught me about features I had to implement in my game. 


 - What **new thing(s)** did you learn / figure out in completing this project?

I had never used Guava before, but I had experience in math class with graphs based around nodes and edges. I used that experience to understand how Guava worked conceptually, but it took a little while to understand Guava methods (I consulted the Guava core libraries). I had to take the methods available in these libraries and create pseudocode to help me understand how I could print adjacent edges (with their values) based on user location. Then, I had to determine how to use an inputted edge value to determine a player’s new location.

Another new thing I learned was how to write to and read a file. Using try and catch statements in the file class was unfamiliar to me, and I didn’t initially know how to create BufferedWriters. However, by far, the hardest part of the file class was figuring out how to take user scores in a file and sort them. I had to learn how to use new data types like ArrayListMultimap and LinkedHashMaps to store and sort score data. I also had to learn new methods, such as ones that converted file contents to strings. Additionally, I had to research how to use for loops that implemented .entries() and .containsKey() methods I had never heard of.

While I worked on the file class and Guava class, my partner Abby took on the graphics class. Even though I didn’t do as much for this class, I did have to learn how the graphics class could be used in the game loop class to display the lab image. I became familiar with the .updateImage() method and how default images must be set for the game to begin, even if this image isn’t the only one used. I then applied this method to the lab class by looking at the other biome class examples Abby had set up and became familiar with how graphics can be implemented in Java.


 - Is there anything that you wish you had **implemented differently**?

If I were to go back and had more time, I would have found a way to consolidate more of the code we created. In the game loop, we found a way to check user location, show paths available, and allow the player to choose a path, but I would be interested to see if there is a way to do this (potentially with hash tables) without using three ArrayLists that store sources, target, and edge values. As we were writing this code, it wasn't always easy to find  online sources to help us outside of Google Core Library documentation. We ended up studying the Guava graph methods that were possible and testing them to create code that could achieve our goal. With more online sources, we might have been able to create more concise code.

I also would have implemented the .txt files differently by consolidating them all into one file. Then, depending on which method I was using, only certain parts of the file would be read. This system would mean that we'd have fewer files to sort through. Ultimately, I mainly want to implement code differently that could have been more concise.


 - If you had **unlimited time**, what additional features would you implement?

If I had unlimited time, I would love to learn how to create my own graphics with mathematical modeling and 3D figures. This feature would not only make this project feel more personal but it would also add a layer of complexity that could be valuable. From there, I’d like to implement graphics that incorporate movement (ex: rolling waves) and sound. In essence, I’d like to create mini-videos that the player sees as they navigate through the game.

Moreover, as players travel to new biomes, I’d like a path to appear on the screen for a limited amount of time (ex: 5 seconds). It would also be interesting to implement animation that shows the user’s inventory being updated with animals found in the biomes.

A final main feature I would like to implement would be mini-games that involve graphics in some way. A flappy bird type game where the player has to click the screen to help the animal escape would add variety and allow the game to extend beyond the text-based focus.


 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?

The most helpful piece of feedback I received while working on the project was from a TA, who I, unfortunately, can’t remember the name of, who told me to use for loops to iterate over our biome map. I took this advice and found an .iterator() method that allowed me to iterate over incident edges in the graph. From there, I realized that I could use ArrayLists to store source, target, and edges in the graph. While the TA might not have been familiar with Guava, she helped me see how I could use the Google Core Libraries to find methods that aided my group in our ultimate goal. It was also beneficial that we were able to achieve the group goals with Guava on our own because it taught us how to apply core library methods we had never used before using our logic. 

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?

If I could give my past self advice, I would tell myself to talk to more project groups working to implement Guava in our current CS 120 class. When I sought help from CS students outside this class, I found that many had never heard of Guava (although they were very helpful), so I think I should have done more early on to speak with those who, while they might still be new to Guava, were familiar with the graph maker and understood what my group was trying to implement.

I would also tell myself to take more breaks if I was stuck. Often, what I needed to do was just come back to my code with fresh eyes. 

Finally, I would have told myself to focus on the hardest parts of the assignment first. Our group did a pretty good job with this, considering that Guava was one of the first things we implemented in the project, but I would have absolutely emphasized this to my past self. With that being said, I would have tried to work on both easier and harder parts of the project at the same time so that I could feel I was making progress even if I was stuck on another part of the project.

 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

Regarding coming up with our initial idea, Abby and I spent time brainstorming together in class about how we might create an engaging game. We had the idea to do an animal game, along with ideas surrounding lots of cool features and challenges for the game that we could implement, such as background stories. We spent lots of time bouncing ideas off of each other, which allowed us both to be on the same page. We also created a shared Google document that we could update with our ideas, which was also very helpful.

When actually designing the code, Abby and I planned how we would split the work. We both felt confident working on certain parts independently while also working on certain parts together. For example, we implemented the biome parent class and flora fauna class together since these would form the basis of our game. From there, we each created two biomes that took advantage of the parent class methods. Since I made a choose-your-own-adventure game like Zork for CS 110, I was open to figuring out the biome connections and user movement options, so I focused on Guava. I also had experience using files for scoreboard purposes (although only in Python), so I was also open to working on the file class. Abby then research and implemented graphics, collected images for our game, and looked into how we might make a lab class. Together, we were able to complete the project in a timely manner and with confidence.


## Sources for Project
https://stackoverflow.com/questions/15649567/sorting-a-text-file-in-java
https://stackoverflow.com/questions/10514473/how-to-convert-a-string-to-a-hashmap
https://www.digitalocean.com/community/tutorials/sort-hashmap-by-value-java 
https://www.geeksforgeeks.org/write-hashmap-to-a-text-file-in-java/ 
https://www.geeksforgeeks.org/how-to-sort-an-arraylist-in-descending-order-in-java/ 
https://www.coderanch.com/t/408361/java/print-lines-file
https://guava.dev/releases/22.0/api/docs/overview-summary.html
ChatGPT (Only for images and riddles, not code)
Grammarly (Only for riddles, not code)
