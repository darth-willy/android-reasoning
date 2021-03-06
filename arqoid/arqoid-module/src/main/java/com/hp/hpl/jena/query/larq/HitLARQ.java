/*
 * (c) Copyright 2007, 2008, 2009 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */

package com.hp.hpl.jena.query.larq;

import org.apache.lucene.document.Document;
//ANDROID: migration to lucene 3.0.2 with lucenoid
//import org.apache.lucene.search.Hit;
import org.apache.lucene.search.ScoreDoc;

import com.hp.hpl.jena.graph.Node;

public class HitLARQ
{
    protected Node node ;
    protected float score ;
    protected int docId ;

 // ANDROID: migration to lucene 3.0.2 with lucenoid
//    public HitLARQ(Hit hit)
//    {
//        try {
//            node = LARQ.build(hit.getDocument()) ;
//            score = hit.getScore() ;
//            docId = hit.getId() ;
//        }
//        catch (Exception e)
//        { throw new ARQLuceneException("node conversion error", e) ; }
//    }
    public HitLARQ(Document doc, ScoreDoc scoreDoc)
    {
        try {
            node = LARQ.build(doc) ;
            score = scoreDoc.score ;
            docId = scoreDoc.doc ;
        }
        catch (Exception e)
        { throw new ARQLuceneException("node conversion error", e) ; }
    }

    public Node getNode()
    {
        return node ;
    }

    public float getScore()
    {
        return score ;
    }
    
    public int getLuceneDocId()
    {
        return docId ;
    }
}

/*
 * (c) Copyright 2007, 2008, 2009 Hewlett-Packard Development Company, LP
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */