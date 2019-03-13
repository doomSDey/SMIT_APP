package com.example.sudipta.smit;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class attendenceAdapter extends RecyclerView.Adapter<attendenceAdapter.attendenceAdapterViewHolder>{

    private Context mCtx;
    private List<attendence_det> attendence_detList;

    public attendenceAdapter(Context mCtx, List<attendence_det> attendence_detList) {
        this.mCtx = mCtx;
        this.attendence_detList = attendence_detList;
    }

    @NonNull
    @Override
    public attendenceAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mCtx);
        View view=layoutInflater.inflate(R.layout.attendence_layout,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new attendenceAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull attendenceAdapterViewHolder holder, int position) {
        attendence_det attendence=attendence_detList.get(position);
        holder.textViewSub.setText(attendence.getSubject()+"("+attendence.getCode()+")" );
       // holder.textViewCode.setText(attendence.getCode() );
        holder.textViewattended.setText("Attended:"+attendence.getAttended() );
        holder.textViewmissed.setText("Missed:"+attendence.getMissed() );
        holder.textViewteacher.setText("Taught by:"+attendence.getTeacher());
        holder.textViewlastUpdated.setText("Last Updated on:"+attendence.getLastUpdated() );
        holder.progressBar.setProgress((int) attendence.getPer());
        Log.d("atten120",attendence.getAttended());
        double x=attendence.getPer();
        int y=(int)x;
        String s=String.valueOf(y);
        holder.textViewper.setText(s+"%");

    }

    @Override
    public int getItemCount() {
        return attendence_detList.size();
    }

    class attendenceAdapterViewHolder extends ViewHolder{
        ProgressBar progressBar;
        TextView textViewSub,textViewCode,textViewattended,textViewmissed,textViewteacher,textViewlastUpdated,textViewper;
        public attendenceAdapterViewHolder(View itemView) {
            super(itemView);
            textViewSub=itemView.findViewById(R.id.textViewTitle);
            //textViewCode=itemView.findViewById(R.id.textView2);
            textViewattended=itemView.findViewById(R.id.attended);
            textViewmissed=itemView.findViewById(R.id.missed);
            textViewteacher=itemView.findViewById(R.id.teacher);
            textViewlastUpdated=itemView.findViewById(R.id.lastupdated);
            textViewper=itemView.findViewById(R.id.textView3);
            progressBar=itemView.findViewById(R.id.progressBar);
        }
    }
}
