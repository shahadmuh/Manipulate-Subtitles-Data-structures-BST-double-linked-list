public class TimeInterval implements Comparable<TimeInterval> {
Time startTime;
Time endTime;
//Impelementaion

TimeInterval(Time startTime, Time endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public int compareTo(TimeInterval that) {
   int thatS=that.startTime.getHH()*3600000+that.startTime.getMM()*60000+that.startTime.getSS()*1000+that.startTime.getMS();
   int thatE=that.endTime.getHH()*3600000+that.endTime.getMM()*60000+that.endTime.getSS()*1000+that.endTime.getMS();
int thisS=this.startTime.getHH()*3600000+this.startTime.getMM()*60000+this.startTime.getSS()*1000+this.startTime.getMS();
   int thisE=this.endTime.getHH()*3600000+this.endTime.getMM()*60000+this.endTime.getSS()*1000+this.endTime.getMS();

		if (thisS>thatE) {
			return 1;
		}
		if (thisE<thatS) {
			return -1;
		}
		return 0;
	}



   // public int calcToMS(Time st){
// int h1, h2, m1, m2, s1, s2, ms1, ms2;
// 
// // m2=(st.getMM())*60000;
// s2=(st.getSS())*1000;
// ms2=st.getMS();
// int tot1=h2+m2+s2+ms2;
// return tot1;
// }


}