import { Injectable } from '@angular/core';
import { Room } from './room';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl = 'http://localhost:8087/api/v1/rooms';

  constructor(private http: HttpClient) { }

  getRoom(id: number) : Observable<any>{
    return  this.http.get(`${this.baseUrl}/${id}`);
  }
  updateRoom(id: number, room: Room) {
    return this.http.put(`${this.baseUrl}/${id}`,room);
  }
  createRoom(room: Room) : Observable<Object>{
    return this.http.post(`${this.baseUrl}`,room);
  }

  getRoomList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  deleteRoom(id: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}/${id}`,{responseType: 'text'});
  }
}
