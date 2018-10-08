package edu.wofford;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GuiMain extends JFrame implements ActionListener {

    private TicTacToeModel theGame;
    private JLabel theLabel;
    private JButton[][] theButtons;

    public void actionPerformed(ActionEvent event) {

        String actionCmd = event.getActionCommand();

        int x, y;

        x = Character.getNumericValue(actionCmd.charAt(0));
        y = Character.getNumericValue(actionCmd.charAt(1));

        if(theGame.setMarkAt(x, y)){
          theButtons[x][y].setText(theGame.getChar(theGame.getMarkAt(x, y)));
        }

        if(theGame.IsGameOver()){
          theLabel.setText(theGame.getResultStr());
        }

    }

    public GuiMain(TicTacToeModel currentGame) {

      theButtons = new JButton[3][3];

      setTitle("Tic Tac Toe");

      setSize(300, 400);
      setResizable(false);

      theLabel = new JLabel("The result");
      theLabel.setName("result");
      theLabel.setHorizontalAlignment(JLabel.CENTER);

      JPanel theButtons = new JPanel();
      theButtons.setLayout(new GridLayout(3, 3));

      JPanel rowOne, rowTwo, rowThree;
      rowOne = new JPanel();
      rowTwo = new JPanel();
      rowThree = new JPanel();

      GridLayout myLayout = new GridLayout(1, 3);
      rowOne.setLayout(myLayout);
      rowTwo.setLayout(myLayout);
      rowThree.setLayout(myLayout);

      for(int row = 0; row < 3; row++){
        for(int col = 0; col < 3; col++){

            String strRow, strCol;
            strRow = Integer.toString(row);
            strCol = Integer.toString(col);

            this.theButtons[row][col] = new JButton();
            this.theButtons[row][col].setName("location" + strRow + strCol);
            this.theButtons[row][col].setActionCommand(strRow + strCol);
            this.theButtons[row][col].addActionListener(this);

            if(row == 0){rowOne.add(this.theButtons[row][col]);}
            if(row == 1){rowTwo.add(this.theButtons[row][col]);}
            if(row == 2){rowThree.add(this.theButtons[row][col]);}

        }
      }

      add(theLabel);
      add(rowOne);
      add(rowTwo);
      add(rowThree);

      setLayout(new GridLayout(4, 1));
      setVisible(true);

    }

    public void startGame(){
      theGame = new TicTacToeModel();
    }


	public static void main(String[] args) {

      TicTacToeModel theGame = new TicTacToeModel();

      GuiMain window = new GuiMain(theGame);
      window.startGame();


	}
}
