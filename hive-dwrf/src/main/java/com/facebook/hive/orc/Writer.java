//  Copyright (c) 2013, Facebook, Inc.  All rights reserved.

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook.hive.orc;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * The interface for writing ORC files.
 */
public interface Writer {
  /**
   * Add arbitrary meta-data to the ORC file. This may be called at any point
   * until the Writer is closed. If the same key is passed a second time, the
   * second value will replace the first.
   * @param key a key to label the data with.
   * @param value the contents of the metadata.
   */
  void addUserMetadata(String key, ByteBuffer value);

  /**
   * Add a row to the ORC file.
   * @param row the row to add
   * @throws IOException
   */
  void addRow(Object row) throws IOException;

  /**
   * Get the raw data size of the last row added
   */
  long getRowRawDataSize();

  /**
   * Flush all of the buffers and close the file. No methods on this writer
   * should be called afterwards.
   * @throws IOException
   */
  void close() throws IOException;
}
