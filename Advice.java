import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Advice{
    public static void main(String[] args) {
       
        ImageIcon icon = resizeIcon("smile.png", 35, 35);

        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font.ttf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            UIManager.put("Label.font", customFont);
            UIManager.put("Button.font", customFont);
            UIManager.put("OptionPane.font", customFont);
            UIManager.put("Panel.font", customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Color softBackground = new Color(230, 240, 250);
        Color softButtonBackground = new Color(174, 198, 207);
        Color softButtonForeground = new Color(0, 43, 54);

        UIManager.put("OptionPane.background", softBackground);
        UIManager.put("Panel.background", softBackground);
        UIManager.put("Button.background", softButtonBackground);
        UIManager.put("Button.foreground", softButtonForeground);

        String name = (String) JOptionPane.showInputDialog(null, 
            "Hi, what's your name?", 
            "Hello User", 
            JOptionPane.QUESTION_MESSAGE, 
            icon, 
            null, 
            ""
        );

        if (name != null && !name.trim().isEmpty()) {
            Object[] options = {"Life Advice", "Love Advice"};
            int response = JOptionPane.showOptionDialog(null, 
                    "Hello " + name + ", what do you need advice on?", 
                    "I'm always here for you.", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    icon, 
                    options, 
                    options[0]);

            if (response == 0) {
                Object[] lifeOptions = {"Dealing with Stress", "Making Life Decisions", "Self-Improvement", "Facing Challenges"};
                int lifeResponse = showCustomOptionDialog("Life Advice", "What aspect of life would you like advice on?", lifeOptions);

                String[] advice = null;

                switch (lifeResponse) {
                    case 0:
                        advice = new String[]{
                            "Take one step at a time. Break down your tasks into manageable pieces.",
                            "Breathe deeply. Sometimes a moment of calm is all you need to refocus.",
                            "Remember, it's okay to ask for help when you feel overwhelmed.",
                            "Stress is a part of life, but it doesn’t have to control you.",
                            "Prioritize self-care. Taking time for yourself is essential to maintaining balance.",
                            "Exercise regularly. Physical activity can reduce stress.",
                            "Connect with loved ones. Social support is crucial in managing stress.",
                            "Practice mindfulness or meditation to stay grounded.",
                            "Avoid overloading your schedule. Learn to say no when necessary.",
                            "Take breaks and rest when needed. Burnout is real and preventable."
                        };
                        break;
                    case 1:
                        advice = new String[]{
                            "Trust your instincts. You know yourself better than anyone else.",
                            "Consider the long-term impact of your decisions, but don’t be afraid to take risks.",
                            "It’s okay to make mistakes. Every decision is a step toward personal growth.",
                            "Sometimes, no decision is worse than making the wrong one.",
                            "Seek advice, but remember that the final choice is yours to make.",
                            "List pros and cons to clarify your choices.",
                            "Reflect on past decisions and their outcomes to guide you.",
                            "Take your time. Rushed decisions often lead to regrets.",
                            "Visualize the possible outcomes to help choose the best path.",
                            "Remember, every decision shapes your journey. Embrace it."
                        };
                        break;
                    case 2:
                        advice = new String[]{
                            "Growth takes time. Celebrate small victories along the way.",
                            "Focus on progress, not perfection.",
                            "Invest in yourself. You’re worth the effort.",
                            "Reflect on your journey. Acknowledge how far you’ve come.",
                            "Remember that self-improvement is a continuous journey.",
                            "Set realistic goals to keep motivated.",
                            "Embrace challenges as opportunities for growth.",
                            "Stay consistent. Improvement happens gradually.",
                            "Learn from feedback, but don't let it discourage you.",
                            "Stay curious. Keep learning and exploring new things."
                        };
                        break;
                    case 3:
                        advice = new String[]{
                            "Challenges are opportunities in disguise.",
                            "Stay resilient. Every challenge you overcome makes you stronger.",
                            "Remember that it's okay to stumble as long as you get back up.",
                            "Take challenges one day at a time.",
                            "Believe in your ability to overcome obstacles.",
                            "Stay positive. Your mindset can greatly affect the outcome.",
                            "Break challenges into smaller, manageable tasks.",
                            "Don't be afraid to ask for help when needed.",
                            "Keep a growth mindset. Challenges lead to development.",
                            "Remember, every challenge is temporary. You will overcome it."
                        };
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "It's okay to take your time. Whenever you're ready, I'm here to listen.", "Life Advice", JOptionPane.INFORMATION_MESSAGE, icon);
                        showGoodbyeMessage(icon); 
                        return;
                }

                if (advice != null) {
                    showAdviceMessages(advice, icon);
                }
            } else if (response == 1) {
                Object[] loveOptions = {"Heartbreak", "Relationship Struggles", "Unrequited Love", "Self-Love"};
                int loveResponse = showCustomOptionDialog("Love Advice", "What are you dealing with in love?", loveOptions);

                String[] advice = null;

                switch (loveResponse) {
                    case 0:
                        advice = new String[]{
                            "Healing takes time, but every day brings you closer to a new beginning.",
                            "Heartbreak can feel overwhelming, but remember that this too shall pass.",
                            "Letting go is hard, but sometimes it's the first step toward finding yourself again.",
                            "Your heart may be broken, but it will heal, and when it does, it will be stronger.",
                            "It's okay to grieve, but remember that every ending is a new beginning.",
                            "Surround yourself with loved ones during this time.",
                            "Focus on self-care and your well-being.",
                            "Allow yourself to feel all emotions without judgment.",
                            "Write down your feelings to process them better.",
                            "Remember, time heals all wounds, and you will emerge stronger."
                        };
                        break;
                    case 1:
                        advice = new String[]{
                            "Every relationship faces challenges.",
                            "Relationships are about growing together.",
                            "Sometimes, it's not about who's right but about finding a solution.",
                            "Even in tough times, love can be the glue that holds you together.",
                            "Remember, it’s not the end of the world, it’s just a rough patch.",
                            "Communicate openly with your partner.",
                            "Take time to understand each other's perspectives.",
                            "Work on resolving issues, not winning arguments.",
                            "Seek counseling if needed to navigate through tough times.",
                            "Remember why you fell in love in the first place."
                        };
                        break;
                    case 2:
                        advice = new String[]{
                            "Unrequited love can be painful, but it doesn't diminish your worth.",
                            "Loving someone who doesn't feel the same way can be hard.",
                            "It's okay to feel what you feel, but don't let it define you.",
                            "Sometimes, the best thing you can do is to let go.",
                            "Remember, the love you seek from others is a reflection of the love you must first give yourself.",
                            "Allow yourself time to heal from unreciprocated feelings.",
                            "Focus on building other meaningful relationships.",
                            "Understand that not every connection is meant to be mutual.",
                            "Redirect your energy into hobbies and passions.",
                            "Remember, you deserve someone who loves you back fully."
                        };
                        break;
                    case 3:
                        advice = new String[]{
                            "Before you can love others, it's important to love yourself.",
                            "You are enough, just as you are.",
                            "Self-love is the foundation of all other relationships.",
                            "Treat yourself with the kindness and love that you would give to your closest friend.",
                            "Loving yourself is a journey, and every step you take is a victory worth celebrating.",
                            "Practice positive self-talk daily.",
                            "Set boundaries that protect your well-being.",
                            "Engage in activities that make you happy and fulfilled.",
                            "Take time to appreciate your unique qualities.",
                            "Remember, self-love is not selfish; it's necessary."
                        };
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "It's okay to take your time. Whenever you're ready, I'm here to listen.", "Love Advice", JOptionPane.INFORMATION_MESSAGE, icon);
                        showGoodbyeMessage(icon);
                        return;
                }

                if (advice != null) {
                    showAdviceMessages(advice, icon);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No worries! I'm here whenever you need me.", "Goodbye", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }

    private static ImageIcon resizeIcon(String path, int width, int height) {
        try {

            ImageIcon originalIcon = new ImageIcon(path);
            Image originalImage = originalIcon.getImage();

            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            return new ImageIcon(resizedImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int showCustomOptionDialog(String title, String message, Object[] options) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < options.length; i++) {
            JRadioButton button = new JRadioButton(options[i].toString());
            button.setActionCommand(String.valueOf(i));
            group.add(button);
            panel.add(button);
        }

        int result = JOptionPane.showConfirmDialog(null, 
            new Object[] { message, panel }, 
            title, 
            JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            for (Component comp : panel.getComponents()) {
                if (comp instanceof JRadioButton) {
                    JRadioButton button = (JRadioButton) comp;
                    if (button.isSelected()) {
                        return Integer.parseInt(button.getActionCommand());
                    }
                }
            }
        }

        return -1;
    }

    private static void showAdviceMessages(String[] advice, ImageIcon icon) {
        for (String msg : advice) {
            JDialog dialog = new JDialog();
            dialog.setTitle("Advice");
            dialog.setModal(true);
            dialog.setSize(400, 160);
            dialog.setLocationRelativeTo(null);
            dialog.setLayout(new BorderLayout());

            JTextArea textArea = new JTextArea(msg);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setFont(new Font("Arial", Font.PLAIN, 12));
            textArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            JScrollPane scrollPane = new JScrollPane(textArea);
            dialog.add(scrollPane, BorderLayout.CENTER);

            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(okButton);
            dialog.add(buttonPanel, BorderLayout.SOUTH);

            dialog.setVisible(true);
        }

        showGoodbyeMessage(icon); 
    }

    private static void showGoodbyeMessage(ImageIcon icon) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Goodbye");
        dialog.setModal(true);
        dialog.setSize(450, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());

        JLabel label = new JLabel("Take care! Remember, I’m always here if you need more advice.", icon, JLabel.LEFT);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        dialog.add(label, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
}
