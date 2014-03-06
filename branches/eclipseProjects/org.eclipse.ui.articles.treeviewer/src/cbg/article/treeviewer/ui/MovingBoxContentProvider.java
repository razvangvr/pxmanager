package cbg.article.treeviewer.ui;

import java.util.Iterator;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import cbg.article.model.Book;
import cbg.article.model.DeltaEvent;
import cbg.article.model.IDeltaListener;
import cbg.article.model.Model;
import cbg.article.model.IModelVisitor;
import cbg.article.model.MovingBox;

public class MovingBoxContentProvider implements ITreeContentProvider,
		IDeltaListener {

	private static Object[] EMPTY_ARRAY = new Object[0];
	protected TreeViewer viewer;

	/*
	 * @see IContentProvider#dispose()
	 */
	public void dispose() {
	}

	/*
	 * @see IContentProvider#inputChanged(Viewer, Object, Object)
	 */
	/**
	 * ------------------------------ The input changed method caches the viewer
	 * argument for later use when responding to events. Recall that the
	 * inputChanged method will be called when the tree viewer's setInput method
	 * is invoked. When the tree viewer's input is changed, we need to make sure
	 * that we remove any listeners we have associated with the old input so
	 * that we no longer receive updates from the stale input. Likewise, we need
	 * to listen for changes in the new input. Typically the content provider
	 * adds itself as a listener to domain object changes. This way when the
	 * domain object changes the content provider is notified and can in turn,
	 * notify the tree viewer. Here is the addListenerTo method. (The
	 * removeListenerFrom method is almost exactly the same so we'll ignore it.)
	 * 
	 * ------------------------------ Notifies this content provider that the
	 * given viewer's input has been switched to a different element.
	 * <p>
	 * A typical use for this method is registering the content provider as a
	 * listener to changes on the new input (using model-specific means), and
	 * deregistering the viewer from the old input. In response to these change
	 * notifications, the content provider propagates the changes to the viewer.
	 * </p>
	 * 
	 * @param viewer
	 *            the viewer
	 * @param oldInput
	 *            the old input element, or <code>null</code> if the viewer did
	 *            not previously have an input
	 * @param newInput
	 *            the new input element, or <code>null</code> if the viewer does
	 *            not have an input
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (TreeViewer) viewer;
		if (oldInput != null) {
			removeListenerFrom((MovingBox) oldInput);
		}
		if (newInput != null) {
			addListenerTo((MovingBox) newInput);
		}
	}

	/**
	 * Because the domain model does not have a richer listener model,
	 * recursively remove this listener from each child box of the given box.
	 */
	protected void removeListenerFrom(MovingBox box) {
		box.removeListener(this);
		for (Iterator iterator = box.getBoxes().iterator(); iterator.hasNext();) {
			MovingBox aBox = (MovingBox) iterator.next();
			removeListenerFrom(aBox);
		}
	}

	/**
	 * Because the domain model does not have a richer listener model,
	 * recursively add this listener to each child box of the given box.
	 * 
	 * This way when the domain object changes the content provider is notified
	 * and can in turn, notify the tree viewer.
	 * 
	 * This method simply finds all the moving boxes and adds the content viewer
	 * as a listener; therefore, if any of the moving boxes change, the content
	 * viewer will be notified. Later in the article we'll show how the content
	 * viewer responds to these domain changes.
	 */
	protected void addListenerTo(MovingBox box) {
		box.addListener(this);
		for (Iterator iterator = box.getBoxes().iterator(); iterator.hasNext();) {
			MovingBox aBox = (MovingBox) iterator.next();
			addListenerTo(aBox);
		}
	}

	/*
	 * @see ITreeContentProvider#getChildren(Object)
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof MovingBox) {
			MovingBox box = (MovingBox) parentElement;
			return concat(box.getBoxes().toArray(), box.getBooks().toArray(),
					box.getGames().toArray());
		}
		return EMPTY_ARRAY;
	}

	protected Object[] concat(Object[] object, Object[] more, Object[] more2) {
		Object[] both = new Object[object.length + more.length + more2.length];
		System.arraycopy(object, 0, both, 0, object.length);
		System.arraycopy(more, 0, both, object.length, more.length);
		System.arraycopy(more2, 0, both, object.length + more.length,
				more2.length);
		return both;
	}

	/*
	 * @see ITreeContentProvider#getParent(Object)
	 */
	public Object getParent(Object element) {
		if (element instanceof Model) {
			return ((Model) element).getParent();
		}
		return null;
	}

	/*
	 * @see ITreeContentProvider#hasChildren(Object)
	 */
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	/*
	 * @see IStructuredContentProvider#getElements(Object)
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/*
	 * @see IDeltaListener#add(DeltaEvent)
	 */
	public void add(DeltaEvent event) {
		Object movingBox = ((Model) event.receiver()).getParent();
		viewer.refresh(movingBox, false);
	}

	/*
	 * @see IDeltaListener#remove(DeltaEvent)
	 */
	public void remove(DeltaEvent event) {
		add(event);
	}

}