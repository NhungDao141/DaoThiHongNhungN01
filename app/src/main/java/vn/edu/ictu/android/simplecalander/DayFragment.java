package vn.edu.ictu.android.simplecalander;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

public class DayFragment extends Fragment {
    private static final String KEY_POSITION = "pos";

    public static DayFragment newInstance(int pos) {
        DayFragment fragment = new DayFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, pos);
        fragment.setArguments(args);
        return fragment;
    }

    private int pos = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments().getInt(KEY_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.day_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, pos);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        TextView tvDay = view.findViewById(R.id.tvDay);
        TextView tvMonth = view.findViewById(R.id.tvMonthYear);
        tvDay.setText(day + "");
        tvMonth.setText(month + "/" + year);
    }
}
