package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import theoaktroop.akshobdaquranshikkha.BookActivity;
import theoaktroop.akshobdaquranshikkha.R;


public class TwoFragment extends Fragment implements View.OnClickListener {

    public TwoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String curURL = "file:///android_asset/ekshobdaQuranSikkha.html";


        View view = inflater.inflate(R.layout.fragment_two, container, false);

        ImageView ekShondaQuranShikkha = (ImageView) view.findViewById(R.id.ekShobdaQuranShikkhaBook);
        ekShondaQuranShikkha.setOnClickListener((View.OnClickListener) this);
        ImageView shundorKoushol = (ImageView) view.findViewById(R.id.shundorKoushol);
        shundorKoushol.setOnClickListener((View.OnClickListener) this);
        ImageView talimulQuran = (ImageView) view.findViewById(R.id.talimulQuran);
        talimulQuran.setOnClickListener((View.OnClickListener) this);
        ImageView duaOZikr = (ImageView) view.findViewById(R.id.duaOZikr);
        duaOZikr.setOnClickListener((View.OnClickListener) this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ekShobdaQuranShikkhaBook:
                Intent intent1 = new Intent(getActivity(), BookActivity.class);
                intent1.putExtra("book_name", "ekShobdaQuranShikkha");
                startActivity(intent1);
                break;
            case R.id.shundorKoushol:
                Intent intent2 = new Intent(getActivity(), BookActivity.class);
                intent2.putExtra("book_name", "shundorKoushol");
                startActivity(intent2);
                break;
            case R.id.talimulQuran:
                Intent intent3 = new Intent(getActivity(), BookActivity.class);
                intent3.putExtra("book_name", "talimulQuran");
                startActivity(intent3);
                break;
            case R.id.duaOZikr:
                Intent intent4 = new Intent(getActivity(), BookActivity.class);
                intent4.putExtra("book_name", "duaOZikr");
                startActivity(intent4);
                break;

        }

    }


}
