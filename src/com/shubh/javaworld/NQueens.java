package com.shubh.javaworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface Queen {
	int row();

	int col();
}

interface Chessboard {
	List<Queen> queens();

	void addQueen(int row, int col);

	void removeQueen(int row, int col);

	Optional<Queen> queenAt(int row, int col);

	boolean queenIsPresent(int row, int col);

	void print();
}

public class NQueens {

	// our board size and # of queens
	private static int n = 8;

	// our chessboard
	private static Chessboard chessboard = createChessboard(n);

	public static void main(String[] args) {
		// Problem: Place n queens on the chessboard, so that they don't
		// threaten each other. The size of the
		// chessboard is n x n.
		//
		// e.g. if n = 5, then one possible solution is:
		// 0 1 2 3 4
		// 0 [ Q . . . . ]
		// 1 [ . . Q . . ]
		// 2 [ . . . . Q ]
		// 3 [ . Q . . . ]
		// 4 [ . . . Q . ]
		//
		// e.g. if n = 4, then one possible solution is:
		// 0 1 2 3
		// 0 [ . Q . . ]
		// 1 [ . . . Q ]
		// 2 [ Q . . . ]
		// 3 [ . . Q . ]
		//
		// e.g. if n = 8, then one possible solution is:
		// 0 1 2 3 4 5 6 7
		// 0 [ Q . . . . . . . ]
		// 1 [ . . . . Q . . . ]
		// 2 [ . . . . . . . Q ]
		// 3 [ . . . . . Q . . ]
		// 4 [ . . Q . . . . . ]
		// 5 [ . . . . . . Q . ]
		// 6 [ . Q . . . . . . ]
		// 7 [ . . . Q . . . . ]

		addQueens();
		chessboard.print();
	}

	public static void addQueens() {
		if (!addQueenHelper(0)) {
			System.out.println("No valid solution exists");
		}
	}

	private static boolean addQueenHelper(int pos) {
		if (pos >= n) {
			return true;
		}

		for (int i = 0; i < n; i++) {
			if (isValidBoard(i, pos)) {
				chessboard.addQueen(i, pos);
				boolean isValid = addQueenHelper(pos + 1);
				if (isValid) {
					return true;
				}
				chessboard.removeQueen(i, pos);
			}
		}

		return false;
	}

	private static boolean isValidBoard(int row, int col) {

		int r, c;
		// Same row on LHS
		for (c = 0; c < col; c++) {
			if (chessboard.queenAt(row, c).isPresent()) {
				return false;
			}
		}

		// Top left diagonal
		for (r = row, c = col; r >= 0 && c >= 0; r--, c--) {
			if (chessboard.queenAt(r, c).isPresent()) {
				return false;
			}
		}

		// Bottom left diagonal
		for (r = row, c = col; r < n && c >= 0; r++, c--) {
			if (chessboard.queenAt(r, c).isPresent()) {
				return false;
			}
		}

		return true;
	}

	/*** Chessboard and Queen implementations below ***/

	public static Chessboard createChessboard(int n) {
		return new Chessboard() {
			private final List<Queen> queens = new ArrayList<>(n);
			private final int size = n;

			public List<Queen> queens() {
				return queens;
			}

			public void addQueen(int row, int col) {
				validateRowAndCol(row, col);
				final Optional<Queen> queen = queenAt(row, col);
				if (!queen.isPresent()) {
					queens.add(new Queen() {
						public int row() {
							return row;
						}

						public int col() {
							return col;
						}
					});
				}
			}

			public void removeQueen(int row, int col) {
				validateRowAndCol(row, col);
				final Optional<Queen> queen = queenAt(row, col);
				queen.ifPresent(q -> queens.remove(q));
			}

			public Optional<Queen> queenAt(int row, int col) {
				validateRowAndCol(row, col);
				return queens.stream().filter(q -> q.row() == row && q.col() == col).findFirst();
			}

			public boolean queenIsPresent(int row, int col) {
				return queenAt(row, col).isPresent();
			}

			public void print() {
				for (int row = 0; row < size; row++) {
					System.out.print("[ ");
					for (int col = 0; col < size; col++) {
						if (queenAt(row, col).isPresent()) {
							System.out.print("Q ");
						} else {
							System.out.print(". ");
						}
					}
					System.out.println(']');
				}
				System.out.println();
			}

			private void validateRowAndCol(int row, int col) {
				if (row < 0 || row >= size) {
					throw new RuntimeException("row [" + row + "] must be between 0 and " + (size - 1) + " inclusive");
				}
				if (col < 0 || col >= size) {
					throw new RuntimeException("col [" + col + "] must be between 0 and " + (size - 1) + " inclusive");
				}
			}
		};
	}
}
