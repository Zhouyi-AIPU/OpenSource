package cn.com.armchina.gbuild.ui.jfreeswt.utils;

import java.awt.BasicStroke;
import java.awt.Stroke;

import javax.xml.crypto.dsig.Transform;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

/**
 * A control for displaying a {@code Stroke} sample.
 */
class SWTStrokeCanvas extends Canvas {

	/**
	 * Creates a new instance.
	 * 
	 * @param parent the parent.
	 * @param style  the style.
	 * @param image  the image.
	 */
	public SWTStrokeCanvas(Composite parent, int style, Image image) {
		this(parent, style);
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param parent the parent.
	 * @param style  the style.
	 */
	public SWTStrokeCanvas(Composite parent, int style) {
		super(parent, style);
		addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				BasicStroke stroke = (BasicStroke) getStroke();
				if (stroke != null) {
					int x, y;
					Rectangle rect = getClientArea();
					x = (rect.width - 100) / 2;
					y = (rect.height - 16) / 2;
					Transform swtTransform = new Transform(e.gc.getDevice());
					e.gc.getTransform(swtTransform);
					swtTransform.translate(x, y);
					e.gc.setTransform(swtTransform);
					swtTransform.dispose();
					e.gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
					e.gc.setLineWidth((int) stroke.getLineWidth());
					e.gc.drawLine(10, 8, 90, 8);
				}
			}
		});
	}

	/**
	 * Sets the stroke.
	 * 
	 * @param stroke the stroke.
	 */
	public void setStroke(Stroke stroke) {
		if (stroke instanceof BasicStroke) {
			setData(stroke);
		} else {
			throw new RuntimeException("Can only handle 'Basic Stroke' at present.");
		}
	}

	/**
	 * Returns the stroke.
	 * 
	 * @return The stroke.
	 */
	public BasicStroke getStroke() {
		return (BasicStroke) this.getData();
	}
}
