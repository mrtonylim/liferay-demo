create index IX_964B8B48 on RECOG_FriendshipRecognition (uuid_[$COLUMN_LENGTH:75$]);

create index IX_541B613E on RECOG_PerformanceRecognition (recognitionId);
create index IX_26D87B90 on RECOG_PerformanceRecognition (uuid_[$COLUMN_LENGTH:75$]);

create index IX_FA762FBB on RECOG_Recognition (toUserId);
create index IX_448DD220 on RECOG_Recognition (userId);
create index IX_B540545A on RECOG_Recognition (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3FA6295C on RECOG_Recognition (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_F7C1413B on RECOG_Recognition (value[$COLUMN_LENGTH:75$]);