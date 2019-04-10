package com.ricky.materialdesign.custombehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class CustomBehavior extends Behavior<View> {

	public CustomBehavior(Context arg0, AttributeSet arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ����������Ҫ������Щ�ؼ�����������״̬��1.֪������˭��2.ʲô״̬�ı䣩
	 * CoordinatorLayout parent ��������
	 * View child, �ӿؼ�---��Ҫ����dependency���view����ͼ��---�۲���
	   View dependency����Ҫ�������Ǹ�View
	 */
	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, View child,
			View dependency) {
		//�����Ը���ID����TAG���ж�
		return dependency instanceof TextView||super.layoutDependsOn(parent, child, dependency);
	}
	
	/**
	 * ����������view�����ı��ʱ��ص�
	 * �����ڴ˷���������һЩ��Ӧ������������Ч����
	 */
	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, View child,
			View dependency) {
		//��ȡ��������view��״̬---��ֱ����λ��
		int offset = dependency.getTop() - child.getTop();
		//��child����ƽ��
		ViewCompat.offsetTopAndBottom(child, offset);
		child.animate().rotation(child.getTop()*20);
		return true;
	}
	

}
