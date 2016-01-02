package course.labs.todomanager;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ToDoListAdapter extends BaseAdapter {

	private final List<ToDoItem> mItems = new ArrayList<ToDoItem>();
	private final Context mContext;

	private static final String TAG = "Lab-UserInterface";

	public ToDoListAdapter(Context context) {

		mContext = context;

	}

	// Add a ToDoItem to the adapter
	// Notify observers that the data set has changed

	public void add(ToDoItem item) {

		mItems.add(item);
		notifyDataSetChanged();

	}

	// Clears the list adapter of all items.

	public void clear() {

		mItems.clear();
		notifyDataSetChanged();

	}

	// Returns the number of ToDoItems

	@Override
	public int getCount() {

		return mItems.size();

	}

	// Retrieve the number of ToDoItems

	@Override
	public Object getItem(int pos) {

		return mItems.get(pos);

	}

	// Get the ID for the ToDoItem
	// In this case it's just the position

	@Override
	public long getItemId(int pos) {

		return pos;

	}

	// Create a View for the ToDoItem at specified position
	// Remember to check whether convertView holds an already allocated View
	// before created a new View.
	// Consider using the ViewHolder pattern to make scrolling more efficient
	// See: http://developer.android.com/training/improving-layouts/smooth-scrolling.html
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// TODO - Get the current ToDoItem
		final ToDoItem toDoItem = (ToDoItem) getItem(position);


		// TODO - Inflate the View for this ToDoItem
		// from todo_item.xml
		//RelativeLayout itemLayout = null;

		ViewHolder viewHolder = null;
		if (convertView == null) {
			LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = (RelativeLayout) li.inflate(R.layout.todo_item, parent, false);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}


		// Fill in specific ToDoItem data
		// Remember that the data that goes in this View
		// corresponds to the user interface elements defined
		// in the layout file

		// TODO - Display Title in TextView
        viewHolder.titleView.setText(toDoItem.getTitle());
		final TextView titleView = viewHolder.titleView;

		// TODO - Set up Status CheckBox
        viewHolder.statusView.setChecked(toDoItem.getStatus() == ToDoItem.Status.DONE);
		final CheckBox statusView = viewHolder.statusView;

		// TODO - Must also set up an OnCheckedChangeListener,
		// which is called when the user toggles the status checkbox
		statusView.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						showTextNotification("CheckBox changed");
                        
					}
				});

		// TODO - Display Priority in a TextView
        viewHolder.priorityView.setText(toDoItem.getPriority().toString());
		final TextView priorityView = viewHolder.priorityView;

		// TODO - Display Time and Date.
		// Hint - use ToDoItem.FORMAT.format(toDoItem.getDate()) to get date and
		// time String
        viewHolder.dateView.setText(ToDoItem.FORMAT.format(toDoItem.getDate()));
		final TextView dateView = viewHolder.dateView;

		// Return the View you just created
		return convertView;
	}

	static class ViewHolder {
		public TextView titleView;
		public CheckBox statusView;
		public TextView priorityView;
		public TextView dateView;

		public ViewHolder(View base) {
			titleView = (TextView) base.findViewById(R.id.titleView);
			statusView = (CheckBox) base.findViewById(R.id.statusCheckBox);
			priorityView = (TextView) base.findViewById(R.id.priorityView);
			dateView = (TextView) base.findViewById(R.id.dateView);
		}
	}

	public void showTextNotification(String msgToDisplay) {
		Toast.makeText(mContext, msgToDisplay, Toast.LENGTH_SHORT).show();
	}
}


