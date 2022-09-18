import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditeducacionComponent } from './components/educacion/editeducacion.component';
import { NeweducacionComponent } from './components/educacion/neweducacion.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia/new-experiencia.component';
import { EdithabilidadComponent } from './components/habilidades/edithabilidad.component';

import { NewhabilidadComponent } from './components/habilidades/newhabilidad/newhabilidad.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditproyectoComponent } from './components/proyectos/editproyecto.component';
import { NewproyectoComponent } from './components/proyectos/newproyecto.component';
import { EditsobremiComponent } from './components/sobremi/editsobremi.component';
import { NewsobremiComponent } from './components/sobremi/newsobremi.component';

const routes: Routes = [

  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaexp', component: NewExperienciaComponent},
  {path: 'editexp/:id', component: EditExperienciaComponent},
  {path: 'nuevaedu', component: NeweducacionComponent},
  {path: 'editedu/:id', component: EditeducacionComponent},
  {path: 'nuevoproyecto', component: NewproyectoComponent},
  {path: 'editproyecto/:id', component: EditproyectoComponent},
  {path: 'nuevahabilidad', component: NewhabilidadComponent},
  {path: 'edithabilidad/:id', component: EdithabilidadComponent},
  
  {path: 'editsobremi/:id', component: EditsobremiComponent},
  {path: 'nuevosobremi', component: NewsobremiComponent}
  


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
