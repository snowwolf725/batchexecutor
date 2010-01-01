/*
 *  MusicTag Copyright (C)2003,2004
 *
 *  This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser
 *  General Public  License as published by the Free Software Foundation; either version 2.1 of the License,
 *  or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 *  the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License along with this library; if not,
 *  you can get a copy from http://www.opensource.org/licenses/lgpl-license.php or write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org.batchexecutor.audiotag.tag.id3.framebody;


import java.nio.ByteBuffer;

import org.batchexecutor.audiotag.tag.InvalidTagException;
import org.batchexecutor.audiotag.tag.id3.ID3v24Frames;


/**
 * Content group description Text information frame.
 * <p>The 'Content group description' frame is used if the sound belongs to a larger category of sounds/music.
 * For example, classical music is often sorted in different musical sections (e.g. "Piano Concerto", "Weather - Hurricane").
 * 
 * <p>For more details, please refer to the ID3 specifications:
 * <ul>
 * <li><a href="http://www.id3.org/id3v2.3.0.txt">ID3 v2.3.0 Spec</a>
 * </ul>
 * 
 * @author : Paul Taylor
 * @author : Eric Farng
 * @version $Id: FrameBodyTIT1.java,v 1.11 2007/11/26 14:20:28 paultaylor Exp $
 */
public class FrameBodyTIT1 extends AbstractFrameBodyTextInfo implements ID3v24FrameBody,ID3v23FrameBody
{
    /**
     * Creates a new FrameBodyTIT1 datatype.
     */
    public FrameBodyTIT1()
    {
    }

    public FrameBodyTIT1(FrameBodyTIT1 body)
    {
        super(body);
    }

    /**
     * Creates a new FrameBodyTIT1 datatype.
     *
     * @param textEncoding 
     * @param text         
     */
    public FrameBodyTIT1(byte textEncoding, String text)
    {
        super(textEncoding, text);
    }

    /**
     * Creates a new FrameBodyTIT1 datatype.
     *                           
     * @throws InvalidTagException 
     */
    public FrameBodyTIT1(ByteBuffer byteBuffer, int frameSize)
        throws InvalidTagException
    {
        super(byteBuffer, frameSize);
    }

      /**
      * The ID3v2 frame identifier
      *
      * @return the ID3v2 frame identifier  for this frame type
     */
    public String getIdentifier()
    {
        return ID3v24Frames.FRAME_ID_CONTENT_GROUP_DESC;
    }
}