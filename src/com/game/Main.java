package com.game;

import java.util.Scanner;

/**
 * Plays a word guessing game with one player.
 */
public class Main {

    public static void main(String[] args) {

        final String[] names = { "SNAKE", "CAT","RABBIT", "COW" };
        String word = names[(int) (Math.random() * names.length)];

        String SECRET_WORD = word;
        final String FLAG = "!";
        String correctWord = "", updatedWord = "" , playerLetterGuess = "", playerWordGuess = "";
        Scanner input = new Scanner(System.in);

        /* begin game */
        System.out.println("Word Guessing Game.\n");
        int numWord = 0;
        int numGuesses = 0;
        for (int i = 0; i < SECRET_WORD.length(); i++) {
            correctWord += "*";								//word as *
            numWord ++;
        }
        System.out.println("Your Word : " + correctWord);				//display the *
        System.out.println("Number of Word : " + numWord);

        /* logic to player guess word */
        do {
            System.out.print("Enter a letter to guess your word (type " + FLAG + " to guess entire word) : ");
            playerLetterGuess = input.nextLine();
            playerLetterGuess = playerLetterGuess.toUpperCase();

            /* count number of guesses */
            numGuesses += 1;

            /* player correctly guessed a letter--extract string in correctWord up to the letter
             * guessed and then append guessed letter to that string. Next, extract rest of
             * correctWord and append after the guessed letter
             */
            if (SECRET_WORD.indexOf(playerLetterGuess) >= 0) {
                updatedWord = correctWord.substring(0, SECRET_WORD.indexOf(playerLetterGuess));
                updatedWord += playerLetterGuess;
                updatedWord += correctWord.substring(SECRET_WORD.indexOf(playerLetterGuess)+1, correctWord.length());
                correctWord = updatedWord;
            }

            /* display guessed letter instead of star(*) */
            System.out.println(correctWord + "\n");
        } while (!playerLetterGuess.equals(FLAG) && !correctWord.equals(SECRET_WORD));

        /* end of game and display message and number of guesses */
        if (playerLetterGuess.equals(FLAG)) {
            System.out.println("What is your guess? ");
            playerWordGuess = input.nextLine();
            playerWordGuess = playerWordGuess.toUpperCase();
        }
        if (playerWordGuess.equals(SECRET_WORD) || correctWord.equals(SECRET_WORD)) {
            System.out.println("Congratulations, You won!");
        } else {
            System.out.println("Sorry, You lose.");
        }
        System.out.println("Your secret word is " + SECRET_WORD);
        System.out.println("You made " + numGuesses + " guesses.");
    }
}