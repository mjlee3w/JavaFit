
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.EnumMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.JPanel;

// Bonus points: Create an icon (or find a public domain icon. Keep in mind federal Copyright law and TAMU's plagiarism policy and add it to the home screen window.

public class MainWindow extends JPanel {
  
  private final JFrame mainFrame = new JFrame(Config.APPLICATIONNAME);
  private final JDialog selectWorkout = new JDialog(mainFrame, "Select Workout");
  private JComboBox<String> cboType, cboGoal;
  private JSpinner spnDuration;
  private final Workouts workouts;
  private final EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups;

  private JButton JButton1 = new JButton("Upper Body Workout");
  private JButton JButton2 = new JButton("Lower Body Workout");
  private JButton JButton3 = new JButton("Whole Body Workout");
 
  MainWindow(Workouts workouts1, EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups1) {
    // Code goes here.
    this.workouts = workouts1;
    this.muscleGroups = muscleGroups1;
    launchHomeScreen();
  }
  
  private void launchHomeScreen() {
    // Code goes here.
    JButton1.setPreferredSize(new Dimension(750,250));
    JButton2.setPreferredSize(new Dimension(750,250));
    JButton3.setPreferredSize(new Dimension(750,250));
    
    JButton2.addActionListener(new ButtonListener());
    JButton3.addActionListener(new ButtonListener());
    JButton1.addActionListener(new ButtonListener());
    
    mainFrame.setPreferredSize(new Dimension(750, 750));
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.add(JButton1, BorderLayout.NORTH);
    mainFrame.add(JButton2, BorderLayout.CENTER);
    mainFrame.add(JButton3, BorderLayout.SOUTH);
    
    ImageIcon img = new ImageIcon("data/logo.png"); //for icon
    mainFrame.setIconImage(img.getImage()); //set icon logo
    
    mainFrame.pack();
    mainFrame.setVisible(true);
  }
  
  // This is the method your actionlistener should call. It should create and display a WorkoutsPanel.
  private void showWorkouts(ArrayList<Config.Muscle> muscles) {
    
    // Code goes here.
    mainFrame.getContentPane().removeAll();
    mainFrame.getContentPane().add(new WorkoutsPanel(muscles, this.workouts));
    mainFrame.setSize(new Dimension(750,750));
    mainFrame.setVisible(true);
    
  }
  
  
  private class ButtonListener implements ActionListener
  {
          public void actionPerformed(ActionEvent e)
          {
                  String actionCommand = e.getActionCommand(); 
                  // gets what was written on GUI Component
                  if(actionCommand.equals("Upper Body Workout"))
                  { 
                    showWorkouts(muscleGroups.get(Config.MuscleGroup.UPPERBODY));
                    return; 
                  }
                  if(actionCommand.equals("Lower Body Workout"))
                  { 
                    showWorkouts(muscleGroups.get(Config.MuscleGroup.LOWERBODY));
                    return; 
                  }
                  if(actionCommand.equals("Whole Body Workout"))
                  { 
                    showWorkouts(muscleGroups.get(Config.MuscleGroup.WHOLEBODY));
                    return; 
                  }
          }
  }


}
