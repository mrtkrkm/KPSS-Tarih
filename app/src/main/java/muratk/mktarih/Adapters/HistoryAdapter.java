package muratk.mktarih.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import muratk.egkpss.R;

public class HistoryAdapter extends BaseAdapter {

    private Context ctx;
    private ArrayList<String> historyModels;

    public HistoryAdapter(Context ctx, ArrayList<String> historyModels){
        this.ctx = ctx;
        this.historyModels = historyModels;
    }

    @Override
    public int getCount() {
        return historyModels.size();
    }

    @Override
    public Object getItem(int position) {
        return historyModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String str_subject_no = "Konu " + (position + 1);
        final String str_subject = historyModels.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.history_layout, parent, false);
            convertView.setPadding(10, 10, 10, 10);
        }

        TextView txt_subject_no = (TextView) convertView.findViewById(R.id.txt_subject_no);
        txt_subject_no.setText(str_subject_no);

        TextView txt_subject = (TextView) convertView.findViewById(R.id.txt_subject);
        txt_subject.setText(str_subject);

        return convertView;
    }
}
