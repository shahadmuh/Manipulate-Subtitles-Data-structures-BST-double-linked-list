// This interface represents a subtitle sequence.
public class SubtitleSeqImp implements SubtitleSeq{
 private SortedMap<TimeInterval, Subtitle> tree = new SortedBST<TimeInterval, Subtitle>();

 	
   // Add a subtitle.
	public void addSubtitle(Subtitle st){
   if (!tree.full()){
   TimeInterval k=new TimeInterval(st.getStartTime(),st.getEndTime());
   tree.insert(k, st);}}
   
	// Return all subtitles in their chronological order.
	public List<Subtitle> getSubtitles(){
   if (!tree.empty()){
   tree.findFirst();
   List<Subtitle> list=new LinkedList<Subtitle>();
   while (!tree.last()){
   list.insert(tree.retrieve().second);
   tree.findNext();}
   list.insert(tree.retrieve().second);
   return list;}
   return null;
    	   
}

	// Return the subtitle displayed at the specified time, null if no
	// subtitle is displayed.
	public Subtitle getSubtitle(Time time){
   if (!tree.empty()){
   TimeInterval k=new TimeInterval(time,time);
   Subtitle st;
   if (tree.find(k)){
   st=tree.retrieve().second;
   return st;}
   else
   return null;}
   return null;
    }
   

	// Return the number of nodes in the search path for finding the subtitle.
	public int nbNodesInSearchPath(Time time){
   if(!tree.empty()){
      int count=0;
   TimeInterval k=new TimeInterval(time,time);
   count=tree.nbNodesInSearchPath(k);
   return count;}
      return 0;}
   

	// Return, in chronological order, all subtitles displayed between the
	// specified start and end times. The first element of this list is the
	// subtitle of which the display interval contains or otherwise comes
	// Immediately after startTime. The last element of this list is the
	// subtitle of which the display interval contains or otherwise comes
	// immediately before endTime.
	public List<Subtitle> getSubtitles(Time startTime, Time endTime){
 
 List<Pair<TimeInterval, Subtitle>> newTree = new LinkedList<Pair<TimeInterval, Subtitle>>();
     List <Subtitle> list=new LinkedList<Subtitle>();
     if (!tree.empty()){
     TimeInterval k1=new TimeInterval(startTime,startTime);
    TimeInterval k2=new TimeInterval(endTime,endTime);

        newTree =tree.inRange(k1,k2);
        newTree.findFirst();
        while(!newTree.last()){
              list.insert(newTree.retrieve().second);
              newTree.findNext();}              
              list.insert(newTree.retrieve().second);}
    
    return list;

              }

	// Shift the subtitles by offseting their start/end times with the specified
	// offset (in milliseconds). The value offset can be positive or negative.
	// Negative time is not allowed and must be replaced with 0. If the end time
	// becomes 0, the subtitle must be removed.
 public int calcToMS(TimeSt st){
 int h1, h2, m1, m2, s1, s2, ms1, ms2; 
 h2=(st.getHH())*3600000;
 m2=(st.getMM())*60000;
 s2=(st.getSS())*1000;
 ms2=st.getMS();
 int tot1=h2+m2+s2+ms2;
 return tot1;
 }


	public void shift(int offset){
 
  if(!tree.empty()){
  TimeInterval k;
  Time start,end;
  int ms=0;
  tree.findFirst();
  while(!tree.last()){
  
start=tree.retrieve().first.startTime;
  ms=calcToMS(((TimeSt)start));
  int tot=offset+ms;
  ((TimeSt)start).calc(tot);
  end=tree.retrieve().first.endTime;
  ms=calcToMS(((TimeSt)start));
  
  if (0>=ms){
  tree.remove();}
  else {
   tot=offset+ms;
  ((TimeSt)end).calc(tot);
  k=new TimeInterval(start,end);
  tree.updateKey(k);}
  tree.findNext();}
  
  start=tree.retrieve().first.startTime;
  ms=calcToMS(((TimeSt)start));
  int tot=offset+ms;
 ((TimeSt)start).calc(tot);
 
  end=tree.retrieve().first.endTime;
  ms=calcToMS(((TimeSt)end));
  if(0<ms){
  tot=offset+ms;
  ((TimeSt)end).calc(tot);
  k=new TimeInterval(start,end);
  tree.updateKey(k);}
  else{
  tree.remove();}
  }
  }
  
  }






