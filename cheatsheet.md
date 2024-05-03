This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.

# Why we didn't do a HELP command
- We chose not to implement a help command in our game because the player is explicity given the directions they must choose to go (ex: south, north, etc.) or whether to answer yes (y) or no (n) in the lab. Additionally, we felt that providing answers to the challenges would too easily allow for cheating. If our game was structured more like ZORK where the user doesn't exactly know what they can type, a help command probably would have been more helpful.


# SPOILER ALERT
- Directions: When asked to choose a direction, the user can type a specific direction based on their location. These directions are listed below.
    - Northwest
    - Northeast
    - Southwest
    - Southeast
    - North
    - South
    - West
    - East
- When asked if they want to view or submit their inventory, the user can type y for yes or n for no.
- The challenges are a collection of riddles that the player must answer about unspecified animals and plants, which belong to a specific biome. The player must collect the animal before they can collect the plant. There is an added challenge within the riddle: each time you guess incorrectly, the designated monster in each biome gets 1 foot closer. On the third, incorrect guess, the player has failed to collect the plant/animal. If they fail to collect either the animal or plant in the biome, their inventory is completely cleared. The answers to the riddles are listed below.
Possible user input:
- Riddle answers:
    - Rainforest animal: Poison dart frog (Source: grammarly)
    - Rainforest plant: cacao (Source: grammarly)
    - Desert animal: camel (Source: grammarly)
    - Desert plant: cactus (Source: grammarly)
    - Aquatic animal: dolphin (Source: ChatGPT)
    - Aquatic plant: sea anemone (Source: ChatGPT)
    - Tundra animal: arctic fox (Source: ChatGPT)
    - Tundra plant: fern (Source: ChatGPT)
- If the player succeeds in collecting both the animal and the plant, they are taken to a secret location where they are given a trivia question. They have one attempt at this trivia question but their inventory is not eaten if they guess incorrectly. However, the secret locations in each biome can only be visited once per game. The answers are listed below.
    - Oasis: Deserts cover what percentage of Earth's land area? 33 (Source: http://www.zo.utexas.edu/courses/thoc/land.html#:~:text=The%20total%20land%20surface%20area,and%20about%2024%25%20is%20mountainous.)
    - Ice Cave: The sun shines up to BLANK hours per day in the tundra summer growing season? 24(Source: https://www.nationalgeographic.com/environment/article/tundra-biome)
    - Forest Canopy: What percentage of sunlight does the rainforest canopy intercept? 95 (Source: https://www.csustan.edu/biology/stan-state-greenhouse/rainforest-understory-adaptations)
    - Coral Reef: Coral reefs are home to what percentage of the world's marine life? 25 (Source: https://floridakeys.noaa.gov/corals/biodiversity.html#:~:text=Covering%20less%20than%20one,anywhere%20else%20in%20the%20world.)

