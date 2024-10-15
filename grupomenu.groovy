(1..2).each{i->
    (1..291).each{j->
    	if ( j==2 ) return
    	if ( i==1 && j==3 ) return
    	if ( i==3 && j==4 ) return
        println "$i,$j"
    }
}

