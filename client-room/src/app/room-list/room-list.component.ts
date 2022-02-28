import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { RoomDetailsComponent } from '../room-details/room-details.component';
import { RoomService } from '../room.service';
import { Room} from '../room';
import { Router } from '@angular/router';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {
  rooms : Observable<Room[]>;

  constructor(private roomService: RoomService, private router: Router) { }
  
  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.rooms = this.roomService.getRoomList();
  }

  deleteRoom(id : number){
    this.roomService.deleteRoom(id).subscribe(
      data => {
        this.reloadData();
      },
      error => console.error(error)
    );
  }

  roomDetails(){
    
  }

}
