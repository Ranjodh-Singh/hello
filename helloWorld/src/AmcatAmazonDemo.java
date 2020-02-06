
    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM

    import java.util.ArrayList;
    import java.util.List;

    // SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
    public class AmcatAmazonDemo
    {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public List<Integer> cellCompete(int[] states, int days)
        {
            // WRITE YOUR CODE HERE

            for(int i=0;i<days;i++){
                int inactive[] =new int[states.length];
                if(states[1]==0){
                    inactive[0]=1;
                }
                if(states[1]==1){
                    inactive[0]=0;
                }
                if(states[states.length-2]==0){
                    inactive[states.length-1]=1;
                }
                if(states[states.length-2]==1){
                    inactive[states.length-1]=0;
                }
                for(int j=1;j<states.length-1;j++){


                    if((states[j-1]==0&&states[j+1]==0)||(states[j-1]==1&&states[j+1]==1)){
                        inactive[j]=1;
                    }
                }
                for(int m=0;m<states.length;m++){
                    if(inactive[m]==1){
                        states[m]=0;
                    }else{
                        states[m]=1;
                    }
                }
            }


            List<Integer> result =new ArrayList<>();
            for(int in :states){
                result.add(in);
            }

            return result;
        }

        // METHOD SIGNATURE ENDS
    }

