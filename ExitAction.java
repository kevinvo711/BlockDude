package school.blockdude;
//stackoverflow and google very helpful
/*
 * Essentially this is a windowListener that closes upon a certain Action
 * Source: http://tips4java.wordpress.com/2009/05/01/closing-an-application/
 * This helped us close the multiple frames that kept popping up after updating to a new level
 * We had trouble with frame.dispose();
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  This class will create and dispatch a WINDOW_CLOSING event to the active
 *  frame.  As a result a request to close the frame will be made and any
 *  WindowListener that handles the windowClosing event will be executed.
 *  Since clicking on the "Close" button of the frame or selecting the "Close"
 *  option from the system menu also invoke the WindowListener, this will
 *  provide a common exit point for the application.
 */
public class ExitAction extends AbstractAction
{
	public ExitAction()
	{
		super("Exit");
		putValue( Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_X) );
	}

	public void actionPerformed(ActionEvent e)
	{
		for (Frame frame : Frame.getFrames()) //get the frames
		{
			if (frame.isActive())
			{
				WindowEvent windowClosing = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
				frame.dispatchEvent(windowClosing);
			}
		}
	}
}