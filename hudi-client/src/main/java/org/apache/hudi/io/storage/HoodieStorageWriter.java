/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hudi.io.storage;

import org.apache.hudi.common.model.HoodieRecord;

import org.apache.avro.generic.IndexedRecord;

import java.io.IOException;

/**
 * HoodieStorageWriter extends the StorageWriter to help limit the size of underlying file. Provides a way to check if
 * the current file can take more records with the <code>canWrite()</code>.
 */
public interface HoodieStorageWriter<R extends IndexedRecord> {

  void writeAvroWithMetadata(R newRecord, HoodieRecord record) throws IOException;

  boolean canWrite();

  void close() throws IOException;

  void writeAvro(String key, R oldRecord) throws IOException;
}
