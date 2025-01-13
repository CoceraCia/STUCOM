/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO1;

import java.util.*;

/**
 *
 * @author migue
 */
public class pokedex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> pokedex = new ArrayList<>();
        menu();
        while (true) {
            System.out.print("Action to execute-->");
            int x = sc.nextInt();
            switch (x) {
                case 0:
                    menu();
                    break;
                case 1:
                    fillPokedexAuto(pokedex);
                    break;
                case 2:
                    addPokemon(pokedex);
                    break;
                case 3:
                    addPokemonAtPosition(pokedex);
                    break;
                case 4:
                    deletePokemon(pokedex);
                    break;
                case 5:
                    deletePokemonAtPosition(pokedex);
                    break;
                case 6:
                    findPokemon(pokedex);
                    break;
                case 7:
                    showPokemon(pokedex);
                    break;
                case 8:
                    getPokemonAtPosition(pokedex);
                    break;
                case 9:
                    countPokemon(pokedex);
                    break;
                case 10:
                    hackPokedex(pokedex);
                    break;
                case 11:
                    erasePokedex(pokedex);
                    break;
                default:
                    if (x != 12) {
                        System.out.println("Incorrect value");
                    }
                    break;
            }
            if (x == 12) {
                System.out.println("Byeeee!!!!");
                break;
            }
        }
    }

    //method that displays the menu
    public static void menu() {
        System.out.println("(0) Show menu");
        System.out.println("(1) Fill Pokedex auto");
        System.out.println("(2) Add Pokemon");
        System.out.println("(3) Add Pokemon at position");
        System.out.println("(4) Delete pokemon");
        System.out.println("(5) Delete Pokemon at Position");
        System.out.println("(6) Find Pokemon");
        System.out.println("(7) Show All Pokemon");
        System.out.println("(8) Get Pokemon at Position");
        System.out.println("(9) Count Pokemon");
        System.out.println("(10) Hack Pokedex");
        System.out.println("(11) Erase Pokedex info");
        System.out.println("(12) Exit");
    }

    //method that fills the pokedex with 5 random pokemons, they cannot be repeated
    public static void fillPokedexAuto(ArrayList<String> pokedex) {
        Random ran = new Random();
        //A list that contains all the Kanto Pokemon
        String[] pokedexKanto = {
            "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard",
            "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree",
            "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot",
            "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok",
            "Pikachu", "Raichu", "Sandshrew", "Sandslash", "Nidoran(female)", "Nidorina", "Nidoqueen",
            "Nidoran(male)", "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales",
            "Jigglypuff", "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume",
            "Paras", "Parasect", "Venonat", "Venomoth", "Diglett", "Dugtrio",
            "Meowth", "Persian", "Psyduck", "Golduck", "Mankey", "Primeape",
            "Growlithe", "Arcanine", "Poliwag", "Poliwhirl", "Poliwrath",
            "Abra", "Kadabra", "Alakazam", "Machop", "Machoke", "Machamp",
            "Bellsprout", "Weepinbell", "Victreebel", "Tentacool", "Tentacruel",
            "Geodude", "Graveler", "Golem", "Ponyta", "Rapidash",
            "Slowpoke", "Slowbro", "Magnemite", "Magneton", "Farfetch'd", "Doduo", "Dodrio",
            "Seel", "Dewgong", "Grimer", "Muk", "Shellder", "Cloyster", "Gastly", "Haunter", "Gengar",
            "Onix", "Drowzee", "Hypno", "Krabby", "Kingler", "Voltorb", "Electrode",
            "Exeggcute", "Exeggutor", "Cubone", "Marowak", "Hitmonlee", "Hitmonchan",
            "Lickitung", "Koffing", "Weezing", "Rhyhorn", "Rhydon",
            "Chansey", "Tangela", "Kangaskhan", "Horsea", "Seadra",
            "Goldeen", "Seaking", "Staryu", "Starmie", "Mr. Mime", "Scyther", "Jynx",
            "Electabuzz", "Magmar", "Pinsir", "Tauros", "Magikarp", "Gyarados",
            "Lapras", "Ditto", "Eevee", "Vaporeon", "Jolteon", "Flareon",
            "Porygon", "Omanyte", "Omastar", "Kabuto", "Kabutops",
            "Aerodactyl", "Snorlax", "Articuno", "Zapdos", "Moltres",
            "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew"
        };
        //We run the code 5 times to apply the kanto pokemons to our pokedex
        for (int i = 0; i < 5; i++) {
            int x;
            while (true) {
                x = ran.nextInt(0, 151);
                if (repeatedPokemon(pokedexKanto[x], pokedex) == false) {
                    pokedex.add(pokedexKanto[x]);
                    break;
                }
            }
        }
    }

    //method that adds a pokemon to the pokedex
    public static void addPokemon(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which pokemon do you want to add?-->");
        String pokemon = sc.nextLine();
        if (repeatedPokemon(pokemon, pokedex) == false) {
            pokedex.add(pokemon);
        } else {
            System.out.println("Cannot add to the pokedex, pokemon already exists");
        }

    }

    //method that adds a pokemon to the pokedex at a certain position
    public static void addPokemonAtPosition(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which pokemon do you want to add?-->");
        String pokemon = sc.nextLine();
        System.out.print("At wich position?-->");
        int pos = sc.nextInt();
        if (pos < pokedex.size()) {
            if (repeatedPokemon(pokemon, pokedex) == false) {
                if (pokedex.get(pos).equals("N/A")) {
                    pokedex.set(pos, pokemon);
                    System.out.println("Successfully added");
                } else {
                    System.out.println("Position already occupied");
                }
            } else {
                System.out.println("Cannot add to the pokedex, pokemon already exists");
            }
        } else {
            System.out.println("ERROR, position is above pokedex size");
        }

    }

    //method that shows the pokemons added to the pokedex
    public static void showPokemon(ArrayList<String> pokedex) {
        int count = 0;
        int newLine = 0; //Variable that will check how much pokemons are written per line
        if (pokedex.isEmpty() == false) {
            for (String pokemon : pokedex) {
                System.out.print(count + "-" + pokemon + " | ");
                if (newLine == 10) { //if 10 pokemons have been written, we write a nl and we reset the variable to 0
                    System.out.println("");
                    newLine = 0;
                }
                count++;
                newLine++;
            }
            System.out.println();
        } else {
            System.out.println("There are no pokemons");
        }
    }

    //method that counts your pokemons
    public static void countPokemon(ArrayList<String> pokedex) {
        System.out.println("Total of Pokemons--> " + pokedex.size());
    }

    //method that erase the Pokedex Information, we will erase the entire pokedex info
    public static void erasePokedex(ArrayList<String> pokedex) {
        pokedex.clear();
        System.out.println("Pokedex Cleared");
    }

    //method that deletes a Pokemon
    public static void deletePokemon(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which pokemon do you want to delete?-->");
        String pokemon = sc.nextLine();
        int count = 0; //to count the position of the pokemon deleted
        if (repeatedPokemon(pokemon, pokedex) == true) {
            for (String p : pokedex) {
                if (p.equals(pokemon)) {
                    pokedex.set(count, "N/A");  //set the deleted pokemon as N/A
                    System.out.println("Successfully deleted");
                }
                count++;
            }
        } else {
            System.out.println("Cannot delete, pokemon doesn't exists");
        }
    }

    //method that deletes a Pokemon
    public static void deletePokemonAtPosition(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Set the position do you want to delete-->");
        int pos = sc.nextInt();
        if (pos < pokedex.size()) {
            if (pokedex.get(pos).equals("N/A") == false) {
                pokedex.set(pos, "N/A");
                System.out.println("Successfully deleted");
            } else {
                System.out.println("Position already deleted");
            }
        } else {
            System.out.println("ERROR, position is above pokedex size");
        }
    }

    //method that ask for a position and shows the pokemon
    public static void getPokemonAtPosition(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Set a position-->");
        int pos = sc.nextInt();
        if (pos < pokedex.size()) { //it can't be the same or above the size because it will display an error
            System.out.println("Pokemon-->" + pokedex.get(pos));
        } else {
            System.out.println("ERROR, position is above pokedex size");
        }
    }

    //methods that shows pokemon position and name
    public static void findPokemon(ArrayList<String> pokedex) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which pokemon do you want to find?-->");
        String pokemon = sc.nextLine();
        if (repeatedPokemon(pokemon, pokedex)) {    //if the pokemon exists we will run the code
            int pos = 0;
            for (String p : pokedex) {
                if (p.equals(pokemon)) {
                    System.out.println(pos + " - " + pokemon);
                    break;
                }
                pos++;
            } 
        } else {
            System.out.println("Pokemon doesn't exists, check if it's well written");
        }
    }
    
    //method that replaces the entire pokemons for Ditto's
    public static void hackPokedex(ArrayList<String> pokedex) {
        for (int i = 0; i < pokedex.size(); i++) {
            pokedex.set(i, "Ditto");
        }
        System.out.println("Pokedex Hacked");
    }

    //method that checks if the pokemon is repeated
    public static boolean repeatedPokemon(String pokemon, ArrayList<String> pokedex) {
        boolean repeated = false;
        if (pokedex.isEmpty() == false) { //if it's not empty, we execute the code
            for (String p : pokedex) {
                if (p.equals(pokemon)) {
                    repeated = true;
                    break;
                }
            }
        }

        return repeated;
    }

}
