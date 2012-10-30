/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andrew
 */
public class Minesweeper extends JPanel {

    final JButton[][] buttons;
    int[][] table;
    private final JPanel statusBar;
    
    boolean gameOver = false;
    
    Minesweeper(){
        
        //Master JFrame Layout
        this.setLayout(new BorderLayout());
        
        //Minefield setup, bruhhhhh
        JPanel mineField = new JPanel();
        mineField.setLayout(new GridLayout(10,10));
        
        //Sets the size, so stuff doesn't look all wanky.
        mineField.setPreferredSize(new Dimension(500,500));
        
        //Status Bar. So you can see what's going on... And stuff
        statusBar = new JPanel();
        statusBar.setLayout(new BorderLayout());
        
        //Sets the size again. No Wompy-Jog sizing for us.
        statusBar.setPreferredSize(new Dimension(300,10));
        
        //Sets the values at each button.
        // Corresponding numbers to buttons.
        table = new int[10][10];
        
        ActionListener listener = new MinesweeperListener();
        
        buttons = new JButton[10][10];
        for(int n = 0; n < 10; n++){
            for(int m = 0; m < 10; m++){
                buttons[n][m] = new JButton("");
                buttons[n][m].addActionListener(listener);
                //buttons[n][m].setBackground(Color.gray);
                table[n][m] = -1;
            }
        }
        
        for(int n = 0; n < 10; n++){
            for(int m = 0; m < 10; m++){
                mineField.add(buttons[n][m]);
            }
        }
        this.add(mineField, BorderLayout.SOUTH);
        
        this.add(statusBar,BorderLayout.NORTH);
    }
    class MineFieldUnit {
        
    }
    class MinesweeperListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!gameOver){
                for(int n = 0; n < 10; n++){
                    for(int m = 0; m < 10; m++){
                        if(buttons[n][m] == (JButton)e.getSource()){
                            if(table[n][m] == -1){
                                buttons[n][m].setBackground(Color.gray);
                                buttons[n][m].setForeground(Color.red);
                                buttons[n][m].setText(box.value);
                            }
                        }
                    }
                }
            }
            
        }
        
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,600);
        frame.setTitle("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel minesweeper = new Minesweeper();
        frame.add(minesweeper);
        
        frame.setVisible(true);
    }
}
