package kr.co.tjoeun.studentlist_20210221.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.tjoeun.studentlist_20210221.R
import kr.co.tjoeun.studentlist_20210221.datas.Student
import java.util.*
import kotlin.collections.ArrayList

class StudentAdapter(val mContext : Context,
                     val resId : Int,
                     val mList : ArrayList<Student>) : ArrayAdapter <Student> (mContext, resId, mList) {

    // student_list_item xml 을 가지고 => 코틀린에서 다룰 수 있게 도와주는 변수. (inf) 클래스(LayoutInflater)
    val inf = LayoutInflater.from(mContext)

    // convertView : 재활용으로 사용할 뷰.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if(tempRow == null) {
            tempRow = inf.inflate(R.layout.student_list_item,  null)
        }

        val row = tempRow!!

        // 화면에 뿌려지는 row를 일부 수정하고 나서 => return 되도록.
        // 몇번째 줄에 뿌릴 row인지 파악하고 상황에 맞게 가공.
        // mList 에서 위치(position)에 맞는 학새을 먼저 추출.
        val student = mList[position]

        // row변수(XML 모양)에서 => 필요한 텍스트뷰/이미지뷰 등등을 꺼내오자.(수기 작업)
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)

        // student 의 값을 => 텍스트뷰들에 반영.
        nameTxt.text = student.name


        // 현재 나이를 구해서 반영해주고 싶을때...=> 현재년도 - 출생년도 + 1

        // JAVA의 Calendar 객체 생성 => 기본값 :

        val cal = Calendar.getInstance()
        val age : Int = cal.get(Calendar.YEAR) - student.birthYear + 1
        ageTxt.text = "(${age}세)"
        //ageTxt.text = "(${student.birthYear}세)"


        return row
    }

}