package br.com.dio.util;

import br.com.dio.model.Space;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardGenerator {

    private final static int BOARD_SIZE = 9;
    private final static Random random = new Random();

    public static List<List<Space>> generateBoard(int difficultyLevel) {
        // Passo 1: Gere um tabuleiro completo e válido
        int[][] solvedBoard = generateSolvedBoard();

        // Passo 2: Crie a lista de espaços com os valores esperados
        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_SIZE; j++) {
                spaces.get(i).add(new Space(solvedBoard[i][j], false));
            }
        }
        
        // Passo 3: Remova números com base na dificuldade
        int totalSpacesToRemove = switch (difficultyLevel) {
            case 1 -> 35; // Fácil
            case 2 -> 45; // Médio
            case 3 -> 55; // Difícil
            default -> 40;
        };

        int removedCount = 0;
        while (removedCount < totalSpacesToRemove) {
            int row = random.nextInt(BOARD_SIZE);
            int col = random.nextInt(BOARD_SIZE);

            if (spaces.get(row).get(col).isFixed()) {
                continue;
            }

            spaces.get(row).get(col).setFixed(true);
            removedCount++;
        }
        
        // Passo 4: Retorna o tabuleiro
        return spaces;
    }

    private static int[][] generateSolvedBoard() {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        solve(board);
        return board;
    }
    
    private static boolean solve(int[][] board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= BOARD_SIZE; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = 0; // Backtrack
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < BOARD_SIZE; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        for (int d = 0; d < BOARD_SIZE; d++) {
            if (board[d][col] == num) {
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(BOARD_SIZE);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
