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
import org.batchexecutor.audiotag.tag.datatype.ByteArraySizeTerminated;
import org.batchexecutor.audiotag.tag.datatype.DataTypes;
import org.batchexecutor.audiotag.tag.datatype.NumberFixedLength;
import org.batchexecutor.audiotag.tag.datatype.StringNullTerminated;
import org.batchexecutor.audiotag.tag.id3.ID3v24Frames;

/**
 * Encryption method registration frame.
 * 
 * <p>
 * To identify with which method a frame has been encrypted the
 * encryption method must be registered in the tag with this frame. The
 * 'Owner identifier' is a null-terminated string with a URL
 * containing an email address, or a link to a location where an email
 * address can be found, that belongs to the organisation responsible
 * for this specific encryption method. Questions regarding the
 * encryption method should be sent to the indicated email address. The
 * 'Method symbol' contains a value that is associated with this method
 * throughout the whole tag. Values below $80 are reserved. The 'Method
 * symbol' may optionally be followed by encryption specific data. There
 * may be several "ENCR" frames in a tag but only one containing the
 * same symbol and only one containing the same owner identifier. The
 * method must be used somewhere in the tag. See section 3.3.1, flag j
 * for more information.
 * </p><p><table border=0 width="70%">
 * <tr><td colspan=2>&lt;Header for 'Encryption method registration', ID: "ENCR"&gt;</td></tr>
 * <tr><td>Owner identifier</td><td width="80%">&lt;text string&gt; $00</td></tr>
 * <tr><td>Method symbol   </td><td>$xx                           </td></tr>
 * <tr><td>Encryption data </td><td>&lt;binary data&gt;           </td></tr>
 * </table></p>
 * 
 * <p>For more details, please refer to the ID3 specifications:
 * <ul>
 * <li><a href="http://www.id3.org/id3v2.3.0.txt">ID3 v2.3.0 Spec</a>
 * </ul>
 * 
 * @author : Paul Taylor
 * @author : Eric Farng
 * @version $Id: FrameBodyENCR.java,v 1.12 2007/08/06 16:04:34 paultaylor Exp $
 */
public class FrameBodyENCR extends AbstractID3v2FrameBody implements ID3v24FrameBody,ID3v23FrameBody
{
    /**
     * Creates a new FrameBodyENCR datatype.
     */
    public FrameBodyENCR()
    {
        this.setObjectValue(DataTypes.OBJ_OWNER, "");
        this.setObjectValue(DataTypes.OBJ_METHOD_SYMBOL, (byte) 0);
        this.setObjectValue(DataTypes.OBJ_METHOD_SYMBOL, new byte[0]);
    }

    public FrameBodyENCR(FrameBodyENCR body)
    {
        super(body);
    }

    /**
     * Creates a new FrameBodyENCR datatype.
     *
     * @param owner        
     * @param methodSymbol 
     * @param data         
     */
    public FrameBodyENCR(String owner, byte methodSymbol, byte[] data)
    {
        this.setObjectValue(DataTypes.OBJ_OWNER, owner);
        this.setObjectValue(DataTypes.OBJ_METHOD_SYMBOL, methodSymbol);
        this.setObjectValue(DataTypes.OBJ_METHOD_SYMBOL, data);
    }

    /**
     * Creates a new FrameBodyENCR datatype.
     *
     * @throws InvalidTagException if unable to create framebody from buffer
     */
    public FrameBodyENCR(ByteBuffer byteBuffer, int frameSize)
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
        return  ID3v24Frames.FRAME_ID_ENCRYPTION;
    }

    /**
     * 
     *
     * @param owner 
     */
    public void setOwner(String owner)
    {
        setObjectValue(DataTypes.OBJ_OWNER, owner);
    }

    /**
     * 
     *
     * @return 
     */
    public String getOwner()
    {
        return (String) getObjectValue(DataTypes.OBJ_OWNER);
    }

    /**
     * 
     */
    protected void setupObjectList()
    {
        objectList.add(new StringNullTerminated(DataTypes.OBJ_OWNER, this));
        objectList.add(new NumberFixedLength(DataTypes.OBJ_METHOD_SYMBOL, this, 1));
        objectList.add(new ByteArraySizeTerminated(DataTypes.OBJ_ENCRYPTION_INFO, this));
    }
}
