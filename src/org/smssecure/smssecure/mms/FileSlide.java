/**
 * Copyright (C) 2011 Whisper Systems
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.smssecure.smssecure.mms;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;

import org.smssecure.smssecure.R;
import org.smssecure.smssecure.attachments.Attachment;
import org.smssecure.smssecure.crypto.MasterSecret;
import org.smssecure.smssecure.util.ResUtil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import ws.com.google.android.mms.ContentType;
import ws.com.google.android.mms.pdu.PduPart;

public class FileSlide extends Slide {

  public FileSlide(Context context, Uri uri, long dataSize, String fileName) throws IOException {
    super(context, constructAttachmentFromUri(context, uri, ContentType.SMS_SECURE_FILE, dataSize, fileName));
  }

  public FileSlide(Context context, Attachment attachment) {
    super(context, attachment);
  }

  @Override
  @Nullable
  public Uri getThumbnailUri() {
    return null;
  }

  @Override
  public boolean hasPlaceholder() {
    return true;
  }

  @Override
  public boolean hasFile(){
    return true;
  }

  @Override
  public boolean hasImage() {
    return true;
  }

  @Override
  public String getFileName(){
    return attachment.getFileName();
  }

  @Override
  public @DrawableRes int getPlaceholderRes(Theme theme) {
    return ResUtil.getDrawableRes(theme, R.attr.conversation_attach_file);
  }
}