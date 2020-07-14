package muratk.mktarih.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import muratk.mktarih.Models.FirstInHistoryModel;
import muratk.egkpss.R;

public class HistoryDetailAdapter extends BaseAdapter {

    private Context ctx;
    private ArrayList<FirstInHistoryModel> historyModels;

    public HistoryDetailAdapter(Context ctx, ArrayList<FirstInHistoryModel> historyModels){
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
        final String str_subject = historyModels.get(position).getSubjectContent();

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.history_detail_layout, parent, false);
            convertView.setPadding(10, 10, 10, 10);
        }

        TextView txt_subject = (TextView) convertView.findViewById(R.id.txt_subject_detail);
        txt_subject.setText(str_subject);

        return convertView;
    }
}
