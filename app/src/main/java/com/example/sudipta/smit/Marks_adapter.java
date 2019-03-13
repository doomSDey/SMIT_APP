package com.example.sudipta.smit;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class Marks_adapter extends RecyclerView.Adapter<Marks_adapter.Marks_adapterAdapterViewHolder>{

    private Context mCtx;
    private List<Marks_det> marks_detList;

    public Marks_adapter(Context mCtx, List<Marks_det> marks_detList) {
        this.mCtx = mCtx;
        this.marks_detList = marks_detList;
    }

    @NonNull
    @Override
    public Marks_adapterAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mCtx);
        View view=layoutInflater.inflate(R.layout.marks_layout,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new Marks_adapterAdapterViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull Marks_adapterAdapterViewHolder holder, int position) {
        Marks_det marks_det=marks_detList.get(position);
       // if(marks_det.getCode()!=null && marks_det.getSubject()!=null)
             holder.textViewSub.setText(marks_det.getSubject()+"("+marks_det.getCode()+")" );
        // holder.textViewCode.setText(attendence.getCode() );
        {
            holder.s1.setText("Sessional 1:"+marks_det.getSessional1()+"/50");
            holder.s2.setText("Sessional 2:"+marks_det.getSessional2()+"/50");
            holder.q1.setText("Quiz 1:"+marks_det.getQuiz1()+"/5");
            holder.q1.setText("Quiz 2:"+marks_det.getQuiz2()+"/5");
            holder.atten.setText("Attendence:"+marks_det.getAtttendence()+"/5" );
            holder.assign.setText("Assigment:"+marks_det.getAssignment()+"/5" );

        }
        holder.inter.setText("Internal:"+marks_det.getInternal()+"/50");
        if(marks_det.getEndsem()!="null")
            holder.endsem.setText("End Sem:"+marks_det.getEndsem()+"/50");

            //holder.progressBar.setProgress((int) attendence.getPer());
        //double x=attendence.getPer();
        //int y=(int)x;
        //String s=String.valueOf(y);
        //holder.textViewper.setText(s+"%");

    }

    @Override
    public int getItemCount() {
        return marks_detList.size();
    }

    class Marks_adapterAdapterViewHolder extends ViewHolder{
        TextView textViewSub,q1,q2,s1,s2,atten,assign,inter,endsem;
        public Marks_adapterAdapterViewHolder(View itemView) {
            super(itemView);
            textViewSub=itemView.findViewById(R.id.sub);
            //textViewCode=itemView.findViewById(R.id.textView2);
            q1=itemView.findViewById(R.id.quiz1);
            atten=itemView.findViewById(R.id.attendence12);
            q2=itemView.findViewById(R.id.quiz2);
            s1=itemView.findViewById(R.id.sess1);
            s2=itemView.findViewById(R.id.sess2);
            assign=itemView.findViewById(R.id.assign);
            inter=itemView.findViewById(R.id.internal);
            endsem=itemView.findViewById(R.id.endsem);
        }
    }
}
